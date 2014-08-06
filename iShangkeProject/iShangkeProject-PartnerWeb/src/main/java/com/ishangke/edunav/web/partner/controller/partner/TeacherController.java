package com.ishangke.edunav.web.partner.controller.partner;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ishangke.edunav.common.Config;
import com.ishangke.edunav.common.utilities.file.AliyunMain;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.TeacherPageViewBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.PartnerFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.TeacherConverter;
import com.ishangke.edunav.web.converter.pageview.TeacherPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.TeacherVo;
import com.ishangke.edunav.web.model.pageview.TeacherPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/p-api/v2/teacher")
public class TeacherController extends AbstractController {
    @Autowired
    PartnerFacade partnerFacade;

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryTeacher(TeacherVo teacherVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        TeacherPageViewBo pageViewBo = null;
        TeacherPageViewVo pageViewVo = null;

        try {
            pageViewBo = partnerFacade.queryTeacher(TeacherConverter.fromModel(teacherVo), curUser, PaginationConverter.toBo(paginationVo),
                    permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = TeacherPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    // return the TeacherVo with img url in it
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse uploadLogo(@RequestParam("file") MultipartFile file, @RequestParam(value = "partnerId") int partnerId, HttpServletRequest req,
            HttpServletResponse resp) {

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        TeacherVo teacherVo = new TeacherVo();

        if (!file.isEmpty()) {
            File serverFile = null;
            try {
                String imgUrl = "";

                File dir = new File("tmp");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".png");
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                ImageIO.write(bufferedImage, "png", serverFile);

                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, file.getName(), Config.AliyunTeacherImgBucket);
                teacherVo.setImgUrl(imgUrl);

            } catch (Exception e) {

                return this.handleWebException(new ControllerException("TeacherPhoto 上传失败"), resp);
            } finally {
                if (serverFile != null) {
                    serverFile.delete();
                }
            }
        } else {
            return this.handleWebException(new ControllerException("TeacherPhoto file 为空"), resp);
        }

        return teacherVo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse create(@RequestBody TeacherVo teacherVo, HttpServletRequest req, HttpServletResponse resp) {
        TeacherVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        TeacherBo targetTeacher = TeacherConverter.fromModel(teacherVo);

        TeacherBo responseTeacher = null;
        try {
            responseTeacher = partnerFacade.createTeacher(targetTeacher, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = TeacherConverter.toModel(responseTeacher);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse update(@RequestBody TeacherVo teacherVo, HttpServletRequest req, HttpServletResponse resp) {
        TeacherVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        TeacherBo targetTeacher = TeacherConverter.fromModel(teacherVo);

        TeacherBo responseTeacher = null;
        try {
            responseTeacher = partnerFacade.updateTeacher(targetTeacher, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = TeacherConverter.toModel(responseTeacher);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    JsonResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setId(id);
        TeacherBo targetTeacher = TeacherConverter.fromModel(teacherVo);

        partnerFacade.deleteTeacher(targetTeacher, curUser, permissionTag);
        return new EmptyResponse();
    }

}
