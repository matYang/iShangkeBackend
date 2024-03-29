package com.ishangke.edunav.web.admin.controller.course;


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
import com.ishangke.edunav.common.utilities.file.AliyunMain;
import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.CourseFacade;
import com.ishangke.edunav.facade.admin.PartnerFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CoursePromotionConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CoursePromotionPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CoursePromotionPhotoVo;
import com.ishangke.edunav.web.model.CoursePromotionVo;
import com.ishangke.edunav.web.model.pageview.CoursePromotionPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/coursePromotion")
public class  CoursePromotionController  extends AbstractController {
    
    @Autowired
    PartnerFacade partnerFacade;

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryCoursePromotion(CoursePromotionVo coursePromotionVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionPageViewBo pageViewBo = null;
        CoursePromotionPageViewVo pageViewVo = null;
        try {
            pageViewBo = courseFacade.queryPromotion(CoursePromotionConverter.fromModel(coursePromotionVo), PaginationConverter.toBo(paginationVo));
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CoursePromotionPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse create(@RequestBody CoursePromotionVo coursePromotionVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionVo responseVo = null;

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

        CoursePromotionBo targetCoursePromotion = CoursePromotionConverter.fromModel(coursePromotionVo);
        CoursePromotionBo responseCoursePromotion = null;
        try {
            responseCoursePromotion = courseFacade.createPromotion(targetCoursePromotion, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CoursePromotionConverter.toModel(responseCoursePromotion);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id, @RequestBody CoursePromotionVo coursePromotionVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionVo responseVo = null;

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

        coursePromotionVo.setId(id);
        CoursePromotionBo targetCoursePromotion = CoursePromotionConverter.fromModel(coursePromotionVo);
        CoursePromotionBo responseCoursePromotion = null;
        try {
            responseCoursePromotion = courseFacade.updatePromotion(targetCoursePromotion, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CoursePromotionConverter.toModel(responseCoursePromotion);
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

        CoursePromotionVo coursePromotionVo = new CoursePromotionVo();
        coursePromotionVo.setId(id);
        CoursePromotionBo targetCoursePromotion = CoursePromotionConverter.fromModel(coursePromotionVo);

        try {
            courseFacade.deletePromotion(targetCoursePromotion, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        return new EmptyResponse();
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody JsonResponse upload(@RequestParam("file") MultipartFile file, HttpServletRequest req, HttpServletResponse resp)
            throws ControllerException {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        int partnerId = 0;

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        CoursePromotionPhotoVo coursePromotionPhoto = new CoursePromotionPhotoVo(); 

        if (!file.isEmpty()) {
            File serverFile = null;
            File snapshotFile = null;
            InputStream is = null;
            DigestInputStream dis = null;

            try {
                String imgUrl = "";
                String snapShotUrl = "";
                File dir = new File("tmp");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                MessageDigest md = MessageDigest.getInstance("MD5");
                serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + "." + FileSetting.IMGFILEFORMAT);
                snapshotFile = new File(dir.getAbsolutePath() + File.separator + "snapshot" + file.getName() + "." + FileSetting.IMGFILEFORMAT);
                is = file.getInputStream();
                dis = new DigestInputStream(is, md);

                // creating the buffered images that will be used
                BufferedImage bufferedImage = ImageIO.read(dis);
                // deep copying the buffered image so to be used for thumbnail
                BufferedImage snapShotBufferedImage = FileSetting.bufferDeepCopy(bufferedImage);

                // using Scalr to resize the image
                //bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, 600, 600, Scalr.OP_ANTIALIAS);
                ImageIO.write(bufferedImage, FileSetting.IMGFILEFORMAT, serverFile);

                // calculate the MD5 checksum and use it as part of the file
                // name to make it unique
                byte[] digest = md.digest();
                String checkSumString = FileSetting.getCheckSumString(digest);
                String fullQualifiedName = FileSetting.assembleName(FileSetting.Prefix.COURSEPROMOTIONPHOTO, partnerId, curId, checkSumString);
                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, fullQualifiedName, Config.AliyunClassroomImgBucket);

                // using Scalr to resize the image
                snapShotBufferedImage = Scalr.resize(snapShotBufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, 200, 200, Scalr.OP_ANTIALIAS);
                ImageIO.write(snapShotBufferedImage, FileSetting.IMGFILEFORMAT, snapshotFile);
                String snapShotFullQualifiedName = FileSetting.assembleName(FileSetting.Prefix.COURSEPROMOTIONPHOTO_SNAPSHOT, partnerId, curId, checkSumString);
                snapShotUrl = AliyunMain.uploadImg(partnerId, snapshotFile , snapShotFullQualifiedName, Config.AliyunClassroomImgBucket);

                coursePromotionPhoto.setUrl(imgUrl);

            } catch (Exception e) {
                e.printStackTrace();
                return this.handleWebException(new ControllerException("CoursePromotionPhoto 上传失败"), resp);
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
                if (snapshotFile != null) {
                    snapshotFile.delete();
                }
            }
        } else {
            return this.handleWebException(new ControllerException("CoursePromotionPhoto file 为空"), resp);
        }

        return coursePromotionPhoto;
    }

}
