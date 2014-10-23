package com.ishangke.edunav.web.user.controller.course;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.CourseFacade;
import com.ishangke.edunav.facade.user.PartnerFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CoursePromotionConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CoursePromotionPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CoursePromotionVo;
import com.ishangke.edunav.web.model.pageview.CoursePromotionPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/coursePromotion")
public class  CoursePromotionController  extends AbstractController {
    
    @Autowired
    PartnerFacade partnerFacade;

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryCoursePromotion(CoursePromotionVo coursePromotionVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionPageViewBo pageViewBo = null;
        CoursePromotionPageViewVo pageViewVo = null;
        try {
            pageViewBo = courseFacade.queryPromotion(CoursePromotionConverter.fromModel(coursePromotionVo), PaginationConverter.toBo(paginationVo));
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CoursePromotionPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }


}
