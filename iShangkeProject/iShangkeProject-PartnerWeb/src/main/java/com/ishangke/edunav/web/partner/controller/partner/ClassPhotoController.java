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
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.PartnerFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.ClassPhotoConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.ClassPhotoPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.model.pageview.ClassPhotoPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/p-api/v2/classPhoto")
public class ClassPhotoController extends AbstractController {
    @Autowired
    PartnerFacade partnerFacade;

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryClassPhoto(ClassPhotoVo classPhotoVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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

        ClassPhotoPageViewBo pageViewBo = null;
        ClassPhotoPageViewVo pageViewVo = null;

        try {
            pageViewBo = partnerFacade.queryClassPhoto(ClassPhotoConverter.fromModel(classPhotoVo), curUser, PaginationConverter.toBo(paginationVo),
                    permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = ClassPhotoPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    // return the ClassPhotoVo with img url in it
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse uploadLogo(@RequestParam("file") MultipartFile file, @RequestParam(value = "partnerId") int partnerId, HttpServletRequest req,
            HttpServletResponse resp) throws ControllerException {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        ClassPhotoVo classPhoto = new ClassPhotoVo();

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

                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, file.getName(), Config.AliyunClassroomImgBucket);
                classPhoto.setImgUrl(imgUrl);

            } catch (Exception e) {

                return this.handleWebException(new ControllerException("ClassPhoto 上传失败"), resp);
            } finally {
                if (serverFile != null) {
                    serverFile.delete();
                }
            }
        } else {
            return this.handleWebException(new ControllerException("ClassPhoto file 为空"), resp);
        }

        return classPhoto;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse create(@RequestBody ClassPhotoVo classPhotoVo, HttpServletRequest req, HttpServletResponse resp) {
        ClassPhotoVo responseVo = null;

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

        ClassPhotoBo targetClassPhoto = ClassPhotoConverter.fromModel(classPhotoVo);

        ClassPhotoBo responseClassPhoto = null;
        try {
            responseClassPhoto = partnerFacade.createClassPhoto(targetClassPhoto, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = ClassPhotoConverter.toModel(responseClassPhoto);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse update(@PathVariable("id") int id, @RequestBody ClassPhotoVo classPhotoVo, HttpServletRequest req, HttpServletResponse resp) {
        ClassPhotoVo responseVo = null;

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
        
        classPhotoVo.setId(id);
        ClassPhotoBo targetClassPhoto = ClassPhotoConverter.fromModel(classPhotoVo);
        ClassPhotoBo responseClassPhoto = null;
        try {
            responseClassPhoto = partnerFacade.updateClassPhoto(targetClassPhoto, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = ClassPhotoConverter.toModel(responseClassPhoto);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    JsonResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
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

        ClassPhotoVo classPhotoVo = new ClassPhotoVo();
        classPhotoVo.setId(id);
        ClassPhotoBo targetClassPhoto = ClassPhotoConverter.fromModel(classPhotoVo);

        partnerFacade.deleteClassPhoto(targetClassPhoto, curUser, permissionTag);
        return new EmptyResponse();
    }

}
