package com.ishangke.edunav.web.partner.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.converter.LoginConverter;
import com.ishangke.edunav.web.converter.PasswordConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.LoginVo;
import com.ishangke.edunav.web.model.PasswordVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/p-api/v2/user")
public class UserController extends AbstractController {

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "/login/reference", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse login(@RequestBody LoginVo loginVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;

        String permissionTag = this.getUrl(req);
        boolean remember = (loginVo.getRemember() != null && loginVo.getRemember() == 1);
        SessionBo authSessionBo = this.getSession(req);

        if (loginVo.getAccountIdentifier() == null || loginVo.getAccountIdentifier().length() == 0) {
            return this.handleWebException(new ControllerException("请输入账号"), resp);
        }
        if (loginVo.getPassword() == null || loginVo.getPassword().length() == 0) {
            return this.handleWebException(new ControllerException("请输入密码"), resp);
        }

        UserBo curUser = null;
        int partnerId = -1;
        int roleId = -1;
        try {
            boolean loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
            if (loggedIn) {
                this.handleWebException(new ControllerException("请先登出之前的账号"), resp);
            }

            authSessionBo = userFacade.loginByReference(LoginConverter.fromModel(loginVo), permissionTag);
            if (authSessionBo.getId() > 0) {
                this.openSession(authSessionBo, remember, req, resp);
                
                curUser = userFacade.getCurrentUser(authSessionBo, permissionTag);
                if (IdChecker.notNull(curUser.getId())) {
                    partnerId = userFacade.getPartnerIdByUserId(curUser.getId());
                    roleId = userFacade.getRoleIdByUserId(curUser.getId());
                }
            }
            else {
                this.handleWebException(new ControllerException("登录失败，请稍后再试"), resp);
            }
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }

        responseVo = UserConverter.toModel(curUser);
        responseVo.setPartnerId(partnerId);
        responseVo.setRoleId(roleId);
        return responseVo;
    }

    @RequestMapping(value = "/{id}/logout", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse logout(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        if (authSessionBo.getId() <= 0) {
            // already logged out
            return new EmptyResponse();
        }
        userFacade.disposeSession(authSessionBo, permissionTag);
        this.closeSession(req, resp);

        return new EmptyResponse();
    }

    @RequestMapping(value = "/findSession", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse findSession(HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo userBo = userFacade.authenticate(authSessionBo, permissionTag);
        if (IdChecker.isNull(userBo.getId())) {
            responseVo = new UserVo();
            responseVo.setId(-1);
        } else {
            userBo = userFacade.getCurrentUser(authSessionBo, permissionTag);
            responseVo = UserConverter.toModel(userBo);
            int partnerId = userFacade.getPartnerIdByUserId(userBo.getId());
            responseVo.setPartnerId(partnerId);
        }

        return responseVo;
    }

    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse changePassword(@PathVariable("id") int id, @RequestBody PasswordVo passwordVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        int curId = userFacade.authenticate(authSessionBo, permissionTag).getId();
        boolean loggedIn = curId > 0;
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

        PasswordBo passwordBo = PasswordConverter.fromModel(passwordVo);
        passwordBo.setId(id);
        SessionBo newSession = userFacade.changePassword(passwordBo, permissionTag);
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
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        // user module specific (and maybe partner?)
        if (curId != id) {
            return this.handleWebException(new ControllerException("对不起，您没有权限查看其他用户资料"), resp);
        }

        UserVo queryUser = new UserVo();
        queryUser.setId(curId);
        UserBo responseUser = null;
        int partnerId = -1;
        int roleId = -1;
        try {
            responseUser = userFacade.queryUserInfo(UserConverter.fromModel(queryUser), curUser, permissionTag);
            if (IdChecker.notNull(responseUser.getId())) {
                partnerId = userFacade.getPartnerIdByUserId(responseUser.getId());
                roleId = userFacade.getRoleIdByUserId(responseUser.getId());
            }
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = UserConverter.toModel(responseUser);
        responseVo.setPartnerId(partnerId);
        responseVo.setRoleId(roleId);;
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
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        if (curId != id) {
            return this.handleWebException(new ControllerException("对不起，您只能更新自己的用户信息"), resp);
        }

        UserBo targetUser = UserConverter.fromModel(userVo);
        targetUser.setId(curId);

        UserBo responseUser = null;
        int partnerId = -1;
        try {
            responseUser = userFacade.updateUser(targetUser, curUser, permissionTag);
            if (IdChecker.notNull(responseUser.getId())) {
                partnerId = userFacade.getPartnerIdByUserId(responseUser.getId());
            }
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = UserConverter.toModel(responseUser);
        responseVo.setPartnerId(partnerId);
        return responseVo;
    }
}
