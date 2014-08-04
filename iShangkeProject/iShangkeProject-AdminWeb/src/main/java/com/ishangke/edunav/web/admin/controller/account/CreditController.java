package com.ishangke.edunav.web.admin.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CreditHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CreditPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.AccountFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CreditConverter;
import com.ishangke.edunav.web.converter.CreditHistoryConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CreditHistoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.CreditPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CreditHistoryVo;
import com.ishangke.edunav.web.model.CreditVo;
import com.ishangke.edunav.web.model.pageview.CreditHistoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.CreditPageViewVo;

@Controller
@RequestMapping("/a-api/v2/credit")

public class CreditController extends AbstractController{
    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CreditPageViewVo  queryCredit(CreditVo creditVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        //user module specific, also need to perform null check
        if (creditVo.getId() == null || creditVo.getId() != curId) {
            throw new ControllerException("对不起，您只能查看自己的积分信息");
        }
        
        CreditPageViewBo pageViewBo = null;
        CreditPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryCredit(CreditConverter.fromModel(creditVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = CreditPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CreditHistoryPageViewVo  queryCreditHistory(CreditHistoryVo creditHistoryVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        //user module specific, also need to perform null check
        if (creditHistoryVo.getUserId() == null || creditHistoryVo.getUserId() != curId) {
            throw new ControllerException("对不起，您只能查看自己的积分信息");
        }
        
        CreditHistoryPageViewBo pageViewBo = null;
        CreditHistoryPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryCreditHistory(CreditHistoryConverter.fromModel(creditHistoryVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = CreditHistoryPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    

}
