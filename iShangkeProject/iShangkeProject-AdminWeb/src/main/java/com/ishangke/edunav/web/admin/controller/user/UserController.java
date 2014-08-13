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

import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.UserPageViewBo;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.LoginConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.PasswordConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.UserPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.LoginVo;
import com.ishangke.edunav.web.model.PasswordVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.UserPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/user")
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
        try {
            boolean loggedIn = userFacade.authenticate(authSessionBo, permissionTag).getId() > 0;
            if (loggedIn) {
                throw new ControllerException("请先登出之前的账号");
            }
            authSessionBo = userFacade.loginByReference(LoginConverter.fromModel(loginVo), permissionTag);
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

        UserBo userBo = null;
        try {
            userBo = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        if (userBo.getId() <= 0) {
            responseVo = new UserVo();
            responseVo.setId(-1);
        } else {
            responseVo = UserConverter.toModel(userBo);
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
        if (passwordVo.getOldPassword() == null) {
            return this.handleWebException(new ControllerException("旧密码不能为空"), resp);
        }

        if (passwordVo.getNewPassword() == null) {
            return this.handleWebException(new ControllerException("新密码不能为空"), resp);
        }

        SessionBo newSession = null;
        try {
            PasswordBo passwordBo = PasswordConverter.fromModel(passwordVo);
            passwordBo.setId(id);
            newSession = userFacade.changePassword(passwordBo, permissionTag);
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

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        UserVo queryUser = new UserVo();
        queryUser.setId(id);
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

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }


        UserBo targetUser = UserConverter.fromModel(userVo);
        targetUser.setId(id);

        UserBo responseUser = null;
        try {
            responseUser = userFacade.updateUser(targetUser, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        responseVo = UserConverter.toModel(responseUser);
        return responseVo;
    }

    //此入口除了可以创建普通用户之外， 还可以创建partner 管理员 之类的角色
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createUser(@RequestBody UserVo userVo, HttpServletRequest req, HttpServletResponse resp, @RequestParam(value = "roleId", defaultValue = "") String roleId) {
        UserVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        UserBo responseUser = null;
        if (IdChecker.notNull(userVo.getPartnerId()) && !"".equals(roleId)) {
            int role = Integer.valueOf(roleId);
            if (role > 0) {
                try {
                    PartnerBo partner = new PartnerBo();
                    partner.setId(userVo.getPartnerId());
                    responseUser = userFacade.createPartnerUser(UserConverter.fromModel(userVo), partner, role, curUser, permissionTag);
                } catch (ControllerException c) {
                    return this.handleWebException(c, resp);
                } 
            }
        }
        try {
            responseUser = userFacade.createUser(UserConverter.fromModel(userVo), curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        responseVo = UserConverter.toModel(responseUser);
        return responseVo;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse queryUser(UserVo userVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        UserPageViewVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        UserPageViewBo responseUser = null;
        try {
            responseUser = userFacade.queryUser(UserConverter.fromModel(userVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        responseVo = UserPageViewConverter.toModel(responseUser);
        return responseVo;
    }
}
