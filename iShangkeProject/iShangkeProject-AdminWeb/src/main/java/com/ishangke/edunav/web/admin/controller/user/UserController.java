package com.ishangke.edunav.web.admin.controller.user;

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
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
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

@Controller
@RequestMapping("/a-api/v2/user")
public class UserController extends AbstractController{
    
    @Autowired
    UserFacade userFacade;
    
    @RequestMapping(value = "/login/phone", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody UserVo login(@RequestBody LoginVo loginVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        boolean remember = (loginVo.getRemember() == null || loginVo.getRemember() == 1);
        
        SessionBo authSessionBo = this.getSession(req);
        boolean loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
        
        if (loggedIn) {
            throw new ControllerException("请先登出之前的账号");
        }
        
        authSessionBo = userFacade.loginByPhone(LoginConverter.fromModel(loginVo), permissionTag);
        if (authSessionBo.getId() > 0) {
            this.openSession(authSessionBo, remember, req, resp);
        }
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        responseVo = UserConverter.toModel(curUser);
        
        return responseVo;
    }

    @RequestMapping(value = "/{id}/logout", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody EmptyResponse logout(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        if (authSessionBo.getId() <= 0) {
            //already logged out
            return new EmptyResponse();
        }
        userFacade.disposeSession(authSessionBo, permissionTag);
        this.closeSession(req, resp);
        
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/findSession", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody UserVo  findSession(HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo userBo = userFacade.authenticate(authSessionBo, permissionTag);
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
    public @ResponseBody EmptyResponse cv( @RequestParam(value="phone") String phone, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        UserVo userVo = new UserVo();
        userVo.setPhone(phone);
        userFacade.openCellSession(UserConverter.fromModel(userVo), permissionTag);
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody UserVo register(@RequestBody UserVo userVo, @RequestBody SessionVo cellSessionVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        boolean loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
        if (loggedIn) {
            throw new ControllerException("请先登出之前的账号");
        }
        if (cellSessionVo.getAuthCode() == null) {
            throw new ControllerException("验证码不能为空");
        }
        
        UserBo userBo = UserConverter.fromModel(userVo);
        
        cellSessionVo.setAccountIdentifier(userBo.getPhone());
        cellSessionVo.setAuthCode(cellSessionVo.getAuthCode());
        SessionBo cellSessionBo = SessionConverter.fromMode(cellSessionVo);

        UserBo result = userFacade.registerUser(userBo, cellSessionBo, permissionTag);
        responseVo = UserConverter.toModel(result);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody EmptyResponse fp(@RequestParam(value="phone") String phone, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        UserVo userVo = new UserVo();
        userVo.setPhone(phone);
        userFacade.openForgetPasswordSession(UserConverter.fromModel(userVo), permissionTag);
        
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody UserVo recoverPassword(@RequestBody PasswordVo passwordVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        boolean loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
        if (loggedIn) {
            throw new ControllerException("对不起，您已经登录了");
        }
        if (passwordVo.getAccountIdentifier() == null) {
            throw new ControllerException("手机号码不能为空");
        }
        if (passwordVo.getNewPassword() == null) {
            throw new ControllerException("新密码不能为空");
        }
        if (passwordVo.getAuthCode() == null) {
            throw new ControllerException("验证码不能为空");
        }
        
        UserBo result = userFacade.recoverPassword(PasswordConverter.fromModel(passwordVo), permissionTag);
        responseVo = UserConverter.toModel(result);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody EmptyResponse changePassword(@PathVariable("id") int id, @RequestBody PasswordVo passwordVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        int curId = userFacade.authenticate(authSessionBo, permissionTag).getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        if (curId != id) {
            throw new ControllerException("不可更改他人密码");
        }
        if (passwordVo.getOldPassword() == null) {
            throw new ControllerException("旧密码不能为空");
        }

        if (passwordVo.getNewPassword() == null) {
            throw new ControllerException("新密码不能为空");
        }

        
        userFacade.changePassword(PasswordConverter.fromModel(passwordVo), permissionTag);
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody UserVo getById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        //user module specific (and maybe partner?)
        if (curId != id) {
            throw new ControllerException("对不起，您没有权限查看其他用户资料");
        }
        
        UserVo queryUser = new UserVo();
        queryUser.setId(curId);
        UserBo responseUser = userFacade.queryUserInfo(UserConverter.fromModel(queryUser), curUser, permissionTag);
        responseVo = UserConverter.toModel(responseUser);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody UserVo update(@PathVariable("id") int id, @RequestBody UserVo userVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        if (curId != id) {
            throw new ControllerException("对不起，您只能更新自己的用户信息");
        }
        
        
        UserBo targetUser = UserConverter.fromModel(userVo);
        targetUser.setId(curId);
        
        UserBo responseUser = userFacade.updateUser(targetUser, curUser, permissionTag);
        responseVo = UserConverter.toModel(responseUser);
        return responseVo;
    }
    
}
