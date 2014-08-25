package com.ishangke.edunav.web.user.controller.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
import com.ishangke.edunav.facade.user.CourseFacade;
import com.ishangke.edunav.web.common.OrderByVo;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.CoursePageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.map.CourseMap;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.CoursePageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;



@Controller
@RequestMapping("/api/v2/course")

public class CourseController extends AbstractController{
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
    
    @Autowired
    CourseFacade courseFacade;
    
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCourse(CourseVo courseVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        CoursePageViewBo pageViewBo = null;
        CoursePageViewVo pageViewVo = null;
        List<OrderByVo> listOrder = new ArrayList<>();
        if (CourseMap.COURSE_MAP.get(paginationVo.getColumnKey()) != null && CourseMap.COURSE_MAP.get(paginationVo.getOrder())!= null) {
            listOrder.add(new OrderByVo(CourseMap.COURSE_MAP.get(paginationVo.getColumnKey()), CourseMap.COURSE_MAP.get(paginationVo.getOrder())));
        }
        listOrder.add(new OrderByVo("POPULARITY", "DESC"));
        paginationVo.setOrderByEntities(listOrder);
        paginationVo.setColumnKey(null);
        paginationVo.setOrder(null);
        try {
            pageViewBo = courseFacade.queryCourseByFilter(CourseConverter.fromModel(courseVo), PaginationConverter.toBo(paginationVo), permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        pageViewVo = CoursePageViewConverter.toModel(pageViewBo);
        LOGGER.info("[queryCourse]:" + "category:" + courseVo.getCategoryValue() + ";idSet:" + courseVo.getIdSet().toString() + ";ColumnKey:" + paginationVo.getColumnKey() + ";Order:" + paginationVo.getOrder());
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCourseById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        CourseVo courseVo = new CourseVo();
        courseVo.setId(id);
        CourseBo responseBo = null;
        CourseVo responseVo = null;
        try {
            responseBo = courseFacade.queryCourseById(CourseConverter.fromModel(courseVo), UserConverter.fromModel(new UserVo()), permissionTag);            
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        responseVo = CourseConverter.toModel(responseBo);
        LOGGER.info("[queryCourseById]:" + id);
        return responseVo;
    }
    

}
