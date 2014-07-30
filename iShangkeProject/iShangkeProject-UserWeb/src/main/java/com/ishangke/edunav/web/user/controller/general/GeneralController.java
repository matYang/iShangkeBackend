package com.ishangke.edunav.web.user.controller.general;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.CareerPageViewBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CirclePageViewBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.LocationPageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.commoncontract.model.SchoolPageViewBo;
import com.ishangke.edunav.facade.user.CourseFacade;
import com.ishangke.edunav.facade.user.GeneralFacade;
import com.ishangke.edunav.web.converter.pageview.CareerPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.CategoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.CirclePageViewConverter;
import com.ishangke.edunav.web.converter.pageview.LocationPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.SchoolPageViewConverter;
import com.ishangke.edunav.web.model.CareerVo;
import com.ishangke.edunav.web.model.CategoryVo;
import com.ishangke.edunav.web.model.CircleVo;
import com.ishangke.edunav.web.model.LocationVo;
import com.ishangke.edunav.web.model.SchoolVo;
import com.ishangke.edunav.web.model.pageview.CareerPageViewVo;
import com.ishangke.edunav.web.model.pageview.CategoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.CirclePageViewVo;
import com.ishangke.edunav.web.model.pageview.LocationPageViewVo;
import com.ishangke.edunav.web.model.pageview.SchoolPageViewVo;
import com.ishangke.edunav.web.tree.TreeParser;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/general")
public class GeneralController extends AbstractController{
    
    @Autowired
    GeneralFacade generalFacade;
    
    @Autowired
    CourseFacade courseFacade;
    
    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CategoryPageViewVo  category(@RequestParam(value="keyword") String keyword, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        CategoryBo categoryBo = new CategoryBo();
        PaginationBo paginationBo = new PaginationBo();
        CategoryPageViewBo pageViewBo = null;
        CategoryPageViewVo pageViewVo = null;
        
        if (keyword == null || keyword.length() == 0) {
            pageViewBo = generalFacade.queryCategory(categoryBo, paginationBo, permissionTag);
            pageViewVo = CategoryPageViewConverter.toModel(pageViewBo);
            if (pageViewVo.getData() != null) {
                ArrayList<CategoryVo> treeList = (ArrayList<CategoryVo>) TreeParser.parse(pageViewVo.getData());
                pageViewVo.setData(treeList);
            }
        } else {
            pageViewBo = courseFacade.queryCategoryByKeyword(keyword, permissionTag);
            pageViewVo = CategoryPageViewConverter.toModel(pageViewBo);
        }
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/location", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody LocationPageViewVo  location(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        LocationBo locationBo = new LocationBo();
        PaginationBo paginationBo = new PaginationBo();
        LocationPageViewBo pageViewBo = null;
        LocationPageViewVo pageViewVo = null;
        
        pageViewBo = generalFacade.queryLocation(locationBo, paginationBo, permissionTag);
        pageViewVo = LocationPageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<LocationVo> treeList = (ArrayList<LocationVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }
        
        return pageViewVo;
    }
    
    @RequestMapping(value = "/circle", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CirclePageViewVo  circle(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        CircleBo circleBo = new CircleBo();
        PaginationBo paginationBo = new PaginationBo();
        CirclePageViewBo pageViewBo = null;
        CirclePageViewVo pageViewVo = null;
        
        pageViewBo = generalFacade.queryCircle(circleBo, paginationBo, permissionTag);
        pageViewVo = CirclePageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<CircleVo> treeList = (ArrayList<CircleVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/school", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody SchoolPageViewVo  school(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        SchoolBo schoolBo = new SchoolBo();
        PaginationBo paginationBo = new PaginationBo();
        SchoolPageViewBo pageViewBo = null;
        SchoolPageViewVo pageViewVo = null;
        
        pageViewBo = generalFacade.querySchool(schoolBo, paginationBo, permissionTag);
        pageViewVo = SchoolPageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<SchoolVo> treeList = (ArrayList<SchoolVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/career", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CareerPageViewVo  career(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        CareerBo careerBo = new CareerBo();
        PaginationBo paginationBo = new PaginationBo();
        CareerPageViewBo pageViewBo = null;
        CareerPageViewVo pageViewVo = null;
        
        pageViewBo = generalFacade.queryCareer(careerBo, paginationBo, permissionTag);
        pageViewVo = CareerPageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<CareerVo> treeList = (ArrayList<CareerVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }
        
        return pageViewVo;
    }
    
    
}
