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

public class WithdrawController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryWithdraw(WithdrawVo withdrawVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        //user module specific, also need to perform null check
        if (withdrawVo.getUserId() == null || withdrawVo.getUserId() != curId) {
            throw new ControllerException("对不起，您只能查看自己的积分信息");
        }
        
        WithdrawPageViewBo pageViewBo = null;
        WithdrawPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryWithdraw(WithdrawConverter.fromModel(withdrawVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = WithdrawPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse create(@RequestBody WithdrawVo withdrawVo, HttpServletRequest req, HttpServletResponse resp) {
        WithdrawVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        if (withdrawVo.getUserId() == null || withdrawVo.getUserId() != curId) {
            throw new ControllerException("对不起，您只能创建自己的提款信息");
        }
        
        
        WithdrawBo targetWithdraw = WithdrawConverter.fromModel(withdrawVo);
        
        WithdrawBo responseWithdraw = accountFacade.createWithdraw(targetWithdraw, curUser, permissionTag);
        responseVo = WithdrawConverter.toModel(responseWithdraw);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@RequestBody WithdrawVo withdrawVo, HttpServletRequest req, HttpServletResponse resp) {
        WithdrawVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        if (withdrawVo.getUserId() == null || withdrawVo.getUserId() != curId) {
            throw new ControllerException("对不起，您只能创建自己的提款信息");
        }
        
        
        WithdrawBo targetWithdraw = WithdrawConverter.fromModel(withdrawVo);
        WithdrawBo responseWithdraw = accountFacade.updateWithdraw(targetWithdraw, curUser, permissionTag);
        responseVo = WithdrawConverter.toModel(responseWithdraw);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = "application/json")
    public @ResponseBody JsonResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
          
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        WithdrawVo withdrawVo = new WithdrawVo();
        withdrawVo.setId(id);
        WithdrawBo targetWithdraw = WithdrawConverter.fromModel(withdrawVo);
        
        accountFacade.deleteWithdraw(targetWithdraw, curUser, permissionTag);
        return new EmptyResponse();
    }
    
}
