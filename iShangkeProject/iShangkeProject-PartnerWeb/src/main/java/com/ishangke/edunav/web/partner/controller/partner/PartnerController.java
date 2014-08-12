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
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PartnerPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.PartnerFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.PartnerConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.PartnerPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.PartnerVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.PartnerPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/p-api/v2/partner")
public class PartnerController extends AbstractController {

    @Autowired
    UserFacade userFacade;

    @Autowired
    PartnerFacade partnerFacade;


    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryPartner(PartnerVo partnerVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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

        PartnerPageViewBo pageViewBo = null;
        PartnerPageViewVo pageViewVo = null;
        
        //partner is public info, no need to fill in partnerId when query
        try {
            pageViewBo = partnerFacade.queryPartner(PartnerConverter.fromModel(partnerVo), PaginationConverter.toBo(paginationVo), curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = PartnerPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryPartnerById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
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
        
        
        PartnerVo partnerVo = new PartnerVo();
        partnerVo.setId(id);
        PartnerBo responseBo = null;
        PartnerVo responseVo = null;
        //partner is public info, no need to fill in partnerId when query
        try {
            responseBo = partnerFacade.queryPartnerById(PartnerConverter.fromModel(partnerVo), UserConverter.fromModel(new UserVo()), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = PartnerConverter.toModel(responseBo);

        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse update(@PathVariable("id") int partnerId, @RequestBody PartnerVo partnerVo, HttpServletRequest req, HttpServletResponse resp) {
        PartnerVo responseVo = null;

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

        int sessionPartnerId = userFacade.getPartnerIdByUserId(curId);
        if (IdChecker.notEqual(partnerId, sessionPartnerId)) {
            throw new ControllerException("不可更改其他合作商的信息");
        }
        
        partnerVo.setId(sessionPartnerId);
        PartnerBo targetPartner = PartnerConverter.fromModel(partnerVo);
        PartnerBo responsePartner = null;
        try {
            responsePartner = partnerFacade.updatePartner(targetPartner, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = PartnerConverter.toModel(responsePartner);
        return responseVo;
    }

    @RequestMapping(value = "/{id}/logo", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse uploadLogo(@RequestParam("file") MultipartFile file, @PathVariable("id") int partnerId, HttpServletRequest req,
            HttpServletResponse resp) {

         String permissionTag = this.getUrl(req);
         SessionBo authSessionBo = this.getSession(req);
        
         UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
         int curId = curUser.getId();
         boolean loggedIn = curId > 0;
         if (!loggedIn) {
             throw new ControllerException("对不起，您尚未登录");
         }
         
         int sessionPartnerId = userFacade.getPartnerIdByUserId(curId);
         if (IdChecker.notEqual(partnerId, sessionPartnerId)) {
             throw new ControllerException("不可更改其他合作商的Logo");
         }

        
        PartnerVo partnerVo = new PartnerVo();

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
                serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + "."+FileSetting.IMGFILEFORMAT);
                is = file.getInputStream();
                dis = new DigestInputStream(is, md);
                
                //using Scalr to resize the image
                BufferedImage bufferedImage = ImageIO.read(dis);
                bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, 160, 160, Scalr.OP_ANTIALIAS);
                ImageIO.write(bufferedImage, FileSetting.IMGFILEFORMAT, serverFile);
                
                //calculate the MD5 checksum and use it as part of the file name to make it unique
                byte[] digest = md.digest();
                String checkSumString = FileSetting.getCheckSumString(digest);
                String fullQualifiedName = FileSetting.assembleName(FileSetting.Prefix.LOGO, sessionPartnerId, curId, checkSumString);
                
                imgUrl = AliyunMain.uploadImg(sessionPartnerId, serverFile, fullQualifiedName, Config.AliyunLogoBucket);
                partnerVo.setLogoUrl(imgUrl);
                partnerVo.setId(sessionPartnerId);
                PartnerBo partnerBo = PartnerConverter.fromModel(partnerVo);
                partnerFacade.updatePartner(partnerBo, curUser, permissionTag);

            } catch (Exception e) {
                e.printStackTrace();
                return this.handleWebException(new ControllerException("Logo处理失败"), resp);
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
            return this.handleWebException(new ControllerException("Logo文件为空"), resp);
        }
        return partnerVo;
    }
}
