package com.ishangke.edunav.web.admin.controller.booking;

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
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityPageViewBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.BookingFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.GroupBuyActivityConverter;
import com.ishangke.edunav.web.converter.GroupBuyBookingConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.GroupBuyActivityPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.GroupBuyBookingPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.map.BookingMap;
import com.ishangke.edunav.web.model.GroupBuyActivityVo;
import com.ishangke.edunav.web.model.GroupBuyBookingVo;
import com.ishangke.edunav.web.model.GroupBuyPhotoVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyActivityPageViewVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyBookingPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/groupBuy")
public class GroupBuyController extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createGroupBuyActivity(@RequestBody GroupBuyActivityVo groupBuyActivity, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

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
        GroupBuyActivityBo tartgetGroupBuy = GroupBuyActivityConverter.fromModel(groupBuyActivity);
        GroupBuyActivityBo responseGroupBuy = null;
        GroupBuyActivityVo responseVo = null;
        try {
            responseGroupBuy = bookingFacade.createGroupBuyActivity(tartgetGroupBuy, curUser, permissionTag);
        } catch (Exception e) {
            return this.handleWebException(e, resp);
        }
        responseVo = GroupBuyActivityConverter.toModel(responseGroupBuy);
        return responseVo;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyActivity(GroupBuyActivityVo groupBuyActivityVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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

        GroupBuyActivityPageViewBo pageViewBo = null;
        GroupBuyActivityPageViewVo pageViewVo = null;
        paginationVo.setColumnKey(BookingMap.BOOKING_MAP.get(paginationVo.getColumnKey()));
        paginationVo.setOrder(BookingMap.BOOKING_MAP.get(paginationVo.getOrder()));
        try {
            pageViewBo = bookingFacade.queryGroupBuyActivity(GroupBuyActivityConverter.fromModel(groupBuyActivityVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = GroupBuyActivityPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyBooking(GroupBuyBookingVo groupBuyBookingVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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

        GroupBuyBookingPageViewBo pageViewBo = null;
        GroupBuyBookingPageViewVo pageViewVo = null;
        paginationVo.setColumnKey(BookingMap.BOOKING_MAP.get(paginationVo.getColumnKey()));
        paginationVo.setOrder(BookingMap.BOOKING_MAP.get(paginationVo.getOrder()));
        try {
            pageViewBo = bookingFacade.queryGroupBuyBooking(GroupBuyBookingConverter.fromModel(groupBuyBookingVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = GroupBuyBookingPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }
    
    

    @RequestMapping(value = "/{id}/online", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse online(@PathVariable("id") int id, @RequestBody GroupBuyActivityVo grouBuyActivityVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }

        grouBuyActivityVo.setId(id);
        GroupBuyActivityBo bo = null;
        GroupBuyActivityVo vo = null;
        try {
            bo = bookingFacade.online(GroupBuyActivityConverter.fromModel(grouBuyActivityVo), curUser, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        vo = GroupBuyActivityConverter.toModel(bo);
        return vo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyActivityById(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = null;
        try {
            currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = currentUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        GroupBuyActivityBo groupBuyActivityBo = null;
        try {
            groupBuyActivityBo = bookingFacade.queryGroupBuyActivityById(id);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        GroupBuyActivityVo groupBuyActivityVo = GroupBuyActivityConverter.toModel(groupBuyActivityBo);
        return groupBuyActivityVo;
    }
    
    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyBookingById(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = null;
        try {
            currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = currentUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        GroupBuyBookingBo groupBuyBookingBo = null;
        try {
            groupBuyBookingBo = bookingFacade.queryGroupBuyBookingById(id, currentUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        GroupBuyBookingVo groupBuyBookingVo = GroupBuyBookingConverter.toModel(groupBuyBookingBo);
        return groupBuyBookingVo;
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody JsonResponse upload(@RequestParam("file") MultipartFile file,
    		@RequestParam(defaultValue = "alipay") HttpServletRequest req, HttpServletResponse resp)
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

        GroupBuyPhotoVo groupPhoto = new GroupBuyPhotoVo(); 

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
                String fullQualifiedName = FileSetting.assembleName(FileSetting.Prefix.CLASSPHOTO, partnerId, curId, checkSumString);
                imgUrl = AliyunMain.uploadImg(partnerId, serverFile, fullQualifiedName, Config.AliyunClassroomImgBucket);

                // using Scalr to resize the image
                snapShotBufferedImage = Scalr.resize(snapShotBufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, 200, 200, Scalr.OP_ANTIALIAS);
                ImageIO.write(snapShotBufferedImage, FileSetting.IMGFILEFORMAT, snapshotFile);
                String snapShotFullQualifiedName = FileSetting.assembleName(FileSetting.Prefix.CLASSPHOTO_SNAPSHOT, partnerId, curId, checkSumString);
                snapShotUrl = AliyunMain.uploadImg(partnerId, snapshotFile , snapShotFullQualifiedName, Config.AliyunClassroomImgBucket);

                groupPhoto.setUrl(imgUrl);

            } catch (Exception e) {
                e.printStackTrace();
                return this.handleWebException(new ControllerException("GroupBuyPhoto 上传失败"), resp);
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
            return this.handleWebException(new ControllerException("GroupBuyPhoto file 为空"), resp);
        }

        return groupPhoto;
    }
}
