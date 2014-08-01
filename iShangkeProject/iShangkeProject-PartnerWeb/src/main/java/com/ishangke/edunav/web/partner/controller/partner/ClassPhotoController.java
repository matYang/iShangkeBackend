package com.ishangke.edunav.web.partner.controller.partner;

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

@Controller
@RequestMapping("/p-api/v2/classPhoto")

public class ClassPhotoController extends AbstractController{
    @Autowired
    PartnerFacade partnerFacade;
    
    @Autowired
    UserFacade userFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ClassPhotoPageViewVo  queryClassPhoto(ClassPhotoVo classPhotoVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        
        ClassPhotoPageViewBo pageViewBo = null;
        ClassPhotoPageViewVo pageViewVo = null;
        
        pageViewBo = partnerFacade.queryClassPhoto(ClassPhotoConverter.fromModel(classPhotoVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = ClassPhotoPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    //return the ClassPhotoVo with img url in it
    @RequestMapping(value = "/upload", method = RequestMethod.PUT)
    public @ResponseBody ClassPhotoVo uploadLogo(@RequestParam("file") MultipartFile file, @RequestParam(value="partnerId") int partnerId, HttpServletRequest req, HttpServletResponse resp) {
        
        return new ClassPhotoVo();
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ClassPhotoVo create(@RequestBody ClassPhotoVo classPhotoVo, HttpServletRequest req, HttpServletResponse resp) {
        ClassPhotoVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        ClassPhotoBo targetClassPhoto = ClassPhotoConverter.fromModel(classPhotoVo);
        
        ClassPhotoBo responseClassPhoto = partnerFacade.createClassPhoto(targetClassPhoto, curUser, permissionTag);
        responseVo = ClassPhotoConverter.toModel(responseClassPhoto);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody ClassPhotoVo update(@RequestBody ClassPhotoVo classPhotoVo, HttpServletRequest req, HttpServletResponse resp) {
        ClassPhotoVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        ClassPhotoBo targetClassPhoto = ClassPhotoConverter.fromModel(classPhotoVo);
        
        ClassPhotoBo responseClassPhoto = partnerFacade.updateClassPhoto(targetClassPhoto, curUser, permissionTag);
        responseVo = ClassPhotoConverter.toModel(responseClassPhoto);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = "application/json")
    public @ResponseBody EmptyResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
          
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        ClassPhotoVo classPhotoVo = new ClassPhotoVo();
        classPhotoVo.setId(id);
        ClassPhotoBo targetClassPhoto = ClassPhotoConverter.fromModel(classPhotoVo);
        
        partnerFacade.deleteClassPhoto(targetClassPhoto, curUser, permissionTag);
        return new EmptyResponse();
    }
    
}
