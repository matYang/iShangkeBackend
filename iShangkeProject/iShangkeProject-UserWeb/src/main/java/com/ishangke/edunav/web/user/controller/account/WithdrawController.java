package com.ishangke.edunav.web.user.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.commoncontract.model.WithdrawPageViewBo;
import com.ishangke.edunav.facade.user.AccountFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.WithdrawConverter;
import com.ishangke.edunav.web.converter.pageview.WithdrawPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.WithdrawVo;
import com.ishangke.edunav.web.model.pageview.WithdrawPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/withdraw")
public class WithdrawController extends AbstractController {

    @Autowired
    UserFacade userFacade;

    @Autowired
    AccountFacade accountFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryWithdraw(WithdrawVo withdrawVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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
        // //user module specific, also need to perform null check
        // if (withdrawVo.getUserId() == null || withdrawVo.getUserId() !=
        // curId) {
        // return this.handleWebException(new
        // ControllerException("对不起，您只能查看自己的提款信息"), resp);
        // }
        withdrawVo.setUserId(curId);

        WithdrawPageViewBo pageViewBo = null;
        WithdrawPageViewVo pageViewVo = null;
        
        try {
            pageViewBo = accountFacade.queryWithdraw(WithdrawConverter.fromModel(withdrawVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);     
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
       
        pageViewVo = WithdrawPageViewConverter.toModel(pageViewBo);
        return pageViewVo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse create(@RequestBody WithdrawVo withdrawVo, HttpServletRequest req, HttpServletResponse resp) {
        WithdrawVo responseVo = null;

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

        // if (withdrawVo.getUserId() == null || withdrawVo.getUserId() !=
        // curId) {
        // return this.handleWebException(new
        // ControllerException("对不起，您只能创建自己的提款信息"), resp);
        // }
        withdrawVo.setUserId(curId);

        WithdrawBo responseWithdraw = null;
        try {
            responseWithdraw = accountFacade.createWithdraw(WithdrawConverter.fromModel(withdrawVo), curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }

        responseVo = WithdrawConverter.toModel(responseWithdraw);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id, @RequestBody WithdrawVo withdrawVo, HttpServletRequest req, HttpServletResponse resp) {
        WithdrawVo responseVo = null;

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

        // if (withdrawVo.getUserId() == null || withdrawVo.getUserId() !=
        // curId) {
        // return this.handleWebException(new
        // ControllerException("对不起，您只能创建自己的提款信息"), resp);
        // }
        withdrawVo.setUserId(curId);
        withdrawVo.setId(id);

        WithdrawBo responseWithdraw = null;
        try {
            responseWithdraw = accountFacade.updateWithdraw(WithdrawConverter.fromModel(withdrawVo), curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = WithdrawConverter.toModel(responseWithdraw);
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

        WithdrawVo withdrawVo = new WithdrawVo();
        withdrawVo.setId(id);
        WithdrawBo targetWithdraw = WithdrawConverter.fromModel(withdrawVo);

        try {
            accountFacade.deleteWithdraw(targetWithdraw, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        return new EmptyResponse();
    }

}
