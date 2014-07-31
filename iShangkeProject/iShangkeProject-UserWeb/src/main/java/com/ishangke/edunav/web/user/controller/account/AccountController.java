package com.ishangke.edunav.web.user.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.AccountHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.AccountPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.AccountFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.AccountConverter;
import com.ishangke.edunav.web.converter.AccountHistoryConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.AccountHistoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.AccountPageViewConverter;
import com.ishangke.edunav.web.model.AccountHistoryVo;
import com.ishangke.edunav.web.model.AccountVo;
import com.ishangke.edunav.web.model.pageview.AccountHistoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.AccountPageViewVo;
import com.ishangke.edunav.web.user.controller.AbstractController;
import com.ishangke.edunav.web.user.exception.ControllerException;


@Controller
@RequestMapping("/account")

public class AccountController extends AbstractController{
    
    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody AccountPageViewVo  queryAccount(AccountVo accountVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        //user module specific, also need to perform null check
        if (accountVo.getId() == null || accountVo.getId() != curId) {
            throw new ControllerException("对不起，您只能查看自己的账户信息");
        }
        
        AccountPageViewBo pageViewBo = null;
        AccountPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryAccount(AccountConverter.fromModel(accountVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = AccountPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody AccountHistoryPageViewVo  queryAccountHistory(AccountHistoryVo accountHistoryVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        //user module specific, also need to perform null check
        if (accountHistoryVo.getUserId() == null || accountHistoryVo.getUserId() != curId) {
            throw new ControllerException("对不起，您只能查看自己的账户信息");
        }
        
        AccountHistoryPageViewBo pageViewBo = null;
        AccountHistoryPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryAccountHistory(AccountHistoryConverter.fromModel(accountHistoryVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = AccountHistoryPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    

}
