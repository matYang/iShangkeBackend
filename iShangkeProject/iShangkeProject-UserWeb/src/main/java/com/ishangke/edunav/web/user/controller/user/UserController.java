package com.ishangke.edunav.web.user.controller.user;

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

import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.converter.LoginConverter;
import com.ishangke.edunav.web.converter.PasswordConverter;
import com.ishangke.edunav.web.converter.SessionConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.LoginVo;
import com.ishangke.edunav.web.model.PasswordVo;
import com.ishangke.edunav.web.model.SessionVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/user")
public class UserController extends AbstractController{
    
    @Autowired
    UserFacade userFacade;
    
    @RequestMapping(value = "/login/phone", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse login(@RequestBody LoginVo loginVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        boolean remember = (loginVo.getRemember() == null || loginVo.getRemember() == 1);
        
        SessionBo authSessionBo = this.getSession(req);
        boolean loggedIn;
        UserBo curUser = null;
        
        try {
             loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
             if (loggedIn) {
                 return this.handleWebException(new ControllerException("请先登出之前的账号"), resp);
             }
             authSessionBo = userFacade.loginByPhone(LoginConverter.fromModel(loginVo), permissionTag);
             if (authSessionBo.getId() > 0) {
                 this.openSession(authSessionBo, remember, req, resp);
             }
            
             curUser = userFacade.authenticate(authSessionBo, permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        
        responseVo = UserConverter.toModel(curUser);
        return responseVo;
    }

    @RequestMapping(value = "/{id}/logout", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse logout(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        if (authSessionBo.getId() <= 0) {
            //already logged out
            return new EmptyResponse();
        }
        try {
            userFacade.disposeSession(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        this.closeSession(req, resp);
        
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/findSession", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  findSession(HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo userBo = null;
        try {
             userBo = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        if (userBo.getId() <= 0) {
            responseVo = new UserVo();
            responseVo.setId(-1);
        }
        else {
            responseVo = UserConverter.toModel(userBo);
        }
        
        return responseVo;
    }
    
    
    @RequestMapping(value = "/smsVerification", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse cv( @RequestParam(value="phone") String phone, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        UserVo userVo = new UserVo();
        userVo.setPhone(phone);
        try {
            userFacade.openCellSession(UserConverter.fromModel(userVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse register(@RequestBody UserVo userVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        boolean loggedIn;
        try {
            loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        if (loggedIn) {
            return this.handleWebException(new ControllerException("请先登出之前的账号"), resp);
        }

        if (userVo.getAuthCode() == null) {
            return this.handleWebException(new ControllerException("验证码不能为空"), resp);
        }
        
        SessionVo cellSessionVo = new SessionVo();
        cellSessionVo.setAccountIdentifier(userVo.getPhone());
        cellSessionVo.setAuthCode(userVo.getAuthCode());
        
        UserBo userBo = UserConverter.fromModel(userVo);
        SessionBo cellSessionBo = SessionConverter.fromModel(cellSessionVo);

        UserBo result = null;
        try {
            result = userFacade.registerUser(userBo, cellSessionBo, permissionTag); 
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        if (result.getAuthCode() == null) {
            throw new ControllerException("Session创建失败");
        }
        SessionBo newSession = new SessionBo();
        newSession.setId(result.getId());
        newSession.setAccountIdentifier(result.getPhone());
        newSession.setAuthCode(result.getAuthCode());
        this.openSession(newSession, false, req, resp);
        
        responseVo = UserConverter.toModel(result);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse fp(@RequestParam(value="phone") String phone, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        UserVo userVo = new UserVo();
        userVo.setPhone(phone);
        
        try {
            userFacade.openForgetPasswordSession(UserConverter.fromModel(userVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse recoverPassword(@RequestBody PasswordVo passwordVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        boolean loggedIn;
        try {
            loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        if (loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您已经登录了"), resp);
        }
        if (passwordVo.getAccountIdentifier() == null) {
            return this.handleWebException(new ControllerException("手机号码不能为空"), resp);
        }
        if (passwordVo.getNewPassword() == null) {
            return this.handleWebException(new ControllerException("新密码不能为空"), resp);
        }
        if (passwordVo.getAuthCode() == null) {
            return this.handleWebException(new ControllerException("验证码不能为空"), resp);
        }
        
        SessionBo newSession = null;
        UserBo result = null;
        try {
            newSession = userFacade.recoverPassword(PasswordConverter.fromModel(passwordVo), permissionTag); 
            if (newSession != null && newSession.getId() > 0) {
                result = userFacade.authenticate(newSession, permissionTag);
                this.openSession(newSession, false, req, resp);
            }
            else {
                throw new ControllerException("找回密码出现错误，创建新Session时失败");
            }
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = UserConverter.toModel(result);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse changePassword(@PathVariable("id") int id, @RequestBody PasswordVo passwordVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        int curId;
        try {
            curId = userFacade.authenticate(authSessionBo, permissionTag).getId();
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        if (curId != id) {
            return this.handleWebException(new ControllerException("不可更改他人密码"), resp);
        }
        if (passwordVo.getOldPassword() == null) {
            return this.handleWebException(new ControllerException("旧密码不能为空"), resp);
        }

        if (passwordVo.getNewPassword() == null) {
            return this.handleWebException(new ControllerException("新密码不能为空"), resp);
        }
        
        SessionBo newSession = null;
        try {
            newSession = userFacade.changePassword(PasswordConverter.fromModel(passwordVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        this.openSession(newSession, false, req, resp);
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse getById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        //user module specific (and maybe partner?)
        if (curId != id) {
            return this.handleWebException(new ControllerException("对不起，您没有权限查看其他用户资料"), resp);
        }
        
        UserVo queryUser = new UserVo();
        queryUser.setId(curId);
        UserBo responseUser = null;
        try {
            responseUser = userFacade.queryUserInfo(UserConverter.fromModel(queryUser), curUser, permissionTag); 
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = UserConverter.toModel(responseUser);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id, @RequestBody UserVo userVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        if (curId != id) {
            return this.handleWebException(new ControllerException("对不起，您只能更新自己的用户信息"), resp);
        }
        
        
        UserBo targetUser = UserConverter.fromModel(userVo);
        targetUser.setId(curId);
        
        UserBo responseUser = null;
        try {
            responseUser = userFacade.updateUser(targetUser, curUser, permissionTag); 
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = UserConverter.toModel(responseUser);
        return responseVo;
    }
    
}
