package com.ishangke.edunav.web.partner.controller.course;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.CourseFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.CoursePageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.CoursePageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.reflection.ReflectionService;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/p-api/v2/course")
public class CourseController extends AbstractController {

    @Autowired
    CourseFacade courseFacade;

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse importCourses(@RequestParam("file") MultipartFile file, HttpServletResponse resp) throws ControllerException {
        // Need a User
        int userId = 1;
        UserVo user = new UserVo();
        user.setId(userId);
        UserBo userBo = UserConverter.fromModel(user);
        String permissionTag = "GET/api/v2/course";

        JsonResponse result = new JsonResponse();
        if (file.isEmpty()) {
            return this.handleWebException(new ControllerException("上传文件为空"), resp);
        }

        File dir = new File("tmp");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".xls");

        try {
            byte[] contentInBytes = file.getBytes();
            FileOutputStream fos = new FileOutputStream(serverFile);
            fos.write(contentInBytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            return this.handleWebException(new ControllerException("读取或写入本地文件出错"), resp);
        } finally {
            serverFile.delete();
        }

        Workbook book;
        Sheet sheet;
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(serverFile.getAbsolutePath()));
            book = Workbook.getWorkbook(fis);
            sheet = book.getSheet(0);
        } catch (BiffException | IOException e) {
            return this.handleWebException(new ControllerException("读取xml的时候挂掉了,make sure 你的file 是 .xls 不是 .xlsx"), resp);
        } finally {
            serverFile.delete();
        }

        int row = 0;
        int col = 0;
        int totalRow = sheet.getRows();
        int totalCol = sheet.getColumns();
        int count = 0;
        Map<Integer, String> fmap = new HashMap<Integer, String>();
        Map<String, String> kvmap = new HashMap<String, String>();
        ReflectionService rs = null;
        Cell c = sheet.getCell(col, row);
        if (c != null && !c.equals("")) {
            CourseBo course = new CourseBo();
            for (row = 0; row < totalRow; row++) {
                for (col = 0; col < totalCol; col++) {
                    c = sheet.getCell(col, row);
                    if (row == 0) {
                        String field = c.getContents();
                        kvmap.put(field, null);
                        fmap.put(col, field);
                    } else {
                        String value = c.getContents();
                        kvmap.put(fmap.get(col), value);
                    }
                }
                if (row == 0) {
                    rs = new ReflectionService(course);
                } else {
                    try {
                        course = (CourseBo) rs.getBoFromMap(kvmap);
                        course.setLastModifyTime(DateUtility.getCurTime());
                        course.setCreateTime(DateUtility.getCurTime());
                        courseFacade.createCourse(course, userBo, permissionTag);
                        count++;
                    } catch (IllegalArgumentException | IllegalAccessException | ParseException e) {
                        return this.handleWebException(new ControllerException("导入出错"), resp);
                    } finally {
                        serverFile.delete();
                    }
                }
            }
        }
        if (serverFile.exists()) {
            serverFile.delete();
        }
        result.setMessage("successfully imported " + count + " courses");
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryCourse(CourseVo courseVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        CoursePageViewBo pageViewBo = null;
        CoursePageViewVo pageViewVo = null;

        try {
            pageViewBo = courseFacade
                    .queryCourse(CourseConverter.fromModel(courseVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CoursePageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryCourseById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        CourseVo courseVo = new CourseVo();
        courseVo.setId(id);
        CourseBo responseBo = null;
        CourseVo responseVo = null;

        try {
            responseBo = courseFacade.queryCourseById(CourseConverter.fromModel(courseVo), UserConverter.fromModel(new UserVo()), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CourseConverter.toModel(responseBo);

        return responseVo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse create(@RequestBody CourseVo courseVo, HttpServletRequest req, HttpServletResponse resp) {
        CourseVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        CourseBo targetCourse = CourseConverter.fromModel(courseVo);

        CourseBo responseCourse = null;
        try {
            responseCourse = courseFacade.createCourse(targetCourse, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CourseConverter.toModel(responseCourse);
        return responseVo;
    }

    @RequestMapping(value = "/{id}/{operate}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse transformCourse(@PathVariable("id") int id, @RequestBody CourseVo course, @PathVariable String operate, HttpServletRequest req, HttpServletResponse resp) {
        CourseVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        Integer operationObj = Constant.COURSEOPERATEMAP.get(operate);
        if (operationObj == null) {
            return this.handleWebException(new ControllerException("This course operation is not defined!"), resp);
        }
        
        course.setId(id);
        int operation = operationObj;
        CourseBo courseBo = null;
        try {
            courseBo = courseFacade.transformCourseStatus(CourseConverter.fromModel(course), operation, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CourseConverter.toModel(courseBo);
        return responseVo;
    }

}
