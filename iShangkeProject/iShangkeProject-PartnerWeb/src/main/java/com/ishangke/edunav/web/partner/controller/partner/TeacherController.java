package com.ishangke.edunav.web.partner.controller.partner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imgscalr.Scalr;
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
import com.ishangke.edunav.common.constant.FileSetting;
import com.ishangke.edunav.common.utilities.IdChecker;
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
    public @ResponseBody JsonResponse queryTeacher(TeacherVo teacherVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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

        TeacherPageViewBo pageViewBo = null;
        TeacherPageViewVo pageViewVo = null;
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            teacherVo.setPartnerId(partnerId);
            pageViewBo = partnerFacade.queryTeacher(TeacherConverter.fromModel(teacherVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = TeacherPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    // return the TeacherVo with img url in it
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody JsonResponse upload(@RequestParam("file") MultipartFile file, @RequestParam(value = "partnerId") int partnerId, HttpServletRequest req, HttpServletResponse resp) {

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        if (IdChecker.notEqual(curId, partnerId)) {
            return this.handleWebException(new ControllerException("不能上传其他合作商的教师资料"), resp);
        }
        
        TeacherVo teacherVo = new TeacherVo();

        if (!file.isEmpty()) {
            File serverFile = null;
            InputStream is = null;
            DigestInputStream dis = null;
            try {
                String imgUrl = "";
                File dir = new File("tmp");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                MessageDigest md = MessageDigest.getInstance("MD5");
                serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + "." + FileSetting.IMGFILEFORMAT);
                is = file.getInputStream();
                dis = new DigestInputStream(is, md);

                // using Scalr to resize the image
                BufferedImage bufferedImage = ImageIO.read(dis);
                bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, 400, 400, Scalr.OP_ANTIALIAS);
                ImageIO.write(bufferedImage, FileSetting.IMGFILEFORMAT, serverFile);

                // calculate the MD5 checksum and use it as part of the file
                // name to make it unique
                byte[] digest = md.digest();
                String checkSumString = FileSetting.getCheckSumString(digest);
                String fullQualifiedName = FileSetting.assembleName(FileSetting.Prefix.TEACHER, partnerId, curId, checkSumString);

                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, fullQualifiedName, Config.AliyunTeacherImgBucket);
                teacherVo.setPartnerId(partnerId);
                teacherVo.setImgUrl(imgUrl);

            } catch (Exception e) {
                e.printStackTrace();
                return this.handleWebException(new ControllerException("TeacherPhoto 上传失败"), resp);
            } finally {
                if (dis != null) {
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
    public @ResponseBody JsonResponse create(@RequestBody TeacherVo teacherVo, HttpServletRequest req, HttpServletResponse resp) {
        TeacherVo responseVo = null;

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

        TeacherBo targetTeacher = TeacherConverter.fromModel(teacherVo);
        TeacherBo responseTeacher = null;
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            targetTeacher.setPartnerId(partnerId);
            responseTeacher = partnerFacade.createTeacher(targetTeacher, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = TeacherConverter.toModel(responseTeacher);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id, @RequestBody TeacherVo teacherVo, HttpServletRequest req, HttpServletResponse resp) {
        TeacherVo responseVo = null;

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

        teacherVo.setId(id);
        TeacherBo targetTeacher = TeacherConverter.fromModel(teacherVo);
        TeacherBo responseTeacher = null;
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            targetTeacher.setPartnerId(partnerId);
            responseTeacher = partnerFacade.updateTeacher(targetTeacher, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = TeacherConverter.toModel(responseTeacher);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody JsonResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
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

        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setId(id);
        TeacherBo targetTeacher = TeacherConverter.fromModel(teacherVo);
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            targetTeacher.setPartnerId(partnerId);
            partnerFacade.deleteTeacher(targetTeacher, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }

        return new EmptyResponse();
    }

}
