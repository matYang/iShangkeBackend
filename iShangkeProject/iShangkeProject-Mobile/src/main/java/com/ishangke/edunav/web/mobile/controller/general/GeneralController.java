package com.ishangke.edunav.web.mobile.controller.general;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.CareerPageViewBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CirclePageViewBo;
import com.ishangke.edunav.commoncontract.model.LocationPageViewBo;
import com.ishangke.edunav.commoncontract.model.MajorPageViewBo;
import com.ishangke.edunav.commoncontract.model.SchoolPageViewBo;
import com.ishangke.edunav.facade.user.CourseFacade;
import com.ishangke.edunav.facade.user.GeneralFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CareerConverter;
import com.ishangke.edunav.web.converter.CategoryConverter;
import com.ishangke.edunav.web.converter.CircleConverter;
import com.ishangke.edunav.web.converter.LocationConverter;
import com.ishangke.edunav.web.converter.MajorConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.SchoolConverter;
import com.ishangke.edunav.web.converter.pageview.CareerPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.CategoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.CirclePageViewConverter;
import com.ishangke.edunav.web.converter.pageview.LocationPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.MajorPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.SchoolPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CareerVo;
import com.ishangke.edunav.web.model.CategoryVo;
import com.ishangke.edunav.web.model.CircleVo;
import com.ishangke.edunav.web.model.LocationVo;
import com.ishangke.edunav.web.model.MajorVo;
import com.ishangke.edunav.web.model.SchoolVo;
import com.ishangke.edunav.web.model.pageview.CareerPageViewVo;
import com.ishangke.edunav.web.model.pageview.CategoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.CirclePageViewVo;
import com.ishangke.edunav.web.model.pageview.LocationPageViewVo;
import com.ishangke.edunav.web.model.pageview.MajorPageViewVo;
import com.ishangke.edunav.web.model.pageview.SchoolPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.tree.TreeParser;
import com.ishangke.edunav.web.mobile.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/general")
public class GeneralController extends AbstractController {

    @Autowired
    GeneralFacade generalFacade;

    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse category(@RequestParam(value = "keyword", defaultValue = "") String keyword, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        CategoryVo categoryVo = new CategoryVo();
        PaginationVo paginationVo = new PaginationVo();
        CategoryPageViewBo pageViewBo = null;
        CategoryPageViewVo pageViewVo = null;

        if (keyword == null || keyword.length() == 0) {
            try {
                pageViewBo = generalFacade.queryCategory(CategoryConverter.fromModel(categoryVo), PaginationConverter.toBo(paginationVo), permissionTag);
            } catch (ControllerException c) {
                return this.handleWebException(c, resp);
            }
            pageViewVo = CategoryPageViewConverter.toModel(pageViewBo);
            if (pageViewVo.getData() != null) {
                ArrayList<CategoryVo> treeList = (ArrayList<CategoryVo>) TreeParser.parse(pageViewVo.getData());
                pageViewVo.setData(treeList);
            }
        } else {
            try {
                pageViewBo = courseFacade.queryCategoryByKeyword(keyword, permissionTag);
            } catch (ControllerException c) {
                return this.handleWebException(c, resp);
            }
            pageViewVo = CategoryPageViewConverter.toModel(pageViewBo);
        }

        return pageViewVo;
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse location(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        LocationVo locationVo = new LocationVo();
        PaginationVo paginationVo = new PaginationVo();
        LocationPageViewBo pageViewBo = null;
        LocationPageViewVo pageViewVo = null;
        try {
            pageViewBo = generalFacade.queryLocation(LocationConverter.fromModel(locationVo), PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = LocationPageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<LocationVo> treeList = (ArrayList<LocationVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }

        return pageViewVo;
    }

    @RequestMapping(value = "/circle", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse circle(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        CircleVo circleVo = new CircleVo();
        PaginationVo paginationVo = new PaginationVo();
        CirclePageViewBo pageViewBo = null;
        CirclePageViewVo pageViewVo = null;
        try {
            pageViewBo = generalFacade.queryCircle(CircleConverter.fromModel(circleVo), PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CirclePageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<CircleVo> treeList = (ArrayList<CircleVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }

        return pageViewVo;
    }

    @RequestMapping(value = "/school", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse school(SchoolVo schoolVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        PaginationVo paginationVo = new PaginationVo();
        SchoolPageViewBo pageViewBo = null;
        SchoolPageViewVo pageViewVo = null;
        try {
            pageViewBo = generalFacade.querySchool(SchoolConverter.fromModel(schoolVo), PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = SchoolPageViewConverter.toModel(pageViewBo);
//        if (pageViewVo.getData() != null) {
//            ArrayList<SchoolVo> treeList = (ArrayList<SchoolVo>) TreeParser.parse(pageViewVo.getData());
//            pageViewVo.setData(treeList);
//        }

        return pageViewVo;
    }

    @RequestMapping(value = "/major", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse major(@RequestParam(value = "schoolId", defaultValue = "0") String schoolId, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        int id = 0;
        try {
            id = Integer.parseInt(schoolId);
        } catch (Exception c) {
            return this.handleWebException(new ControllerException("不合法schoolId格式"), resp);
        }
        if (IdChecker.isNull(id)) {
            return this.handleWebException(new ControllerException("不合法schoolId格式"), resp);
        }

        PaginationVo paginationVo = new PaginationVo();
        MajorVo majorVo = new MajorVo();
        majorVo.setSchoolId(id);

        MajorPageViewBo pageViewBo = null;
        MajorPageViewVo pageViewVo = null;
        try {
            pageViewBo = generalFacade.queryMajor(MajorConverter.fromModel(majorVo), PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = MajorPageViewConverter.toModel(pageViewBo);
        return pageViewVo;
    }

    @RequestMapping(value = "/career", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse career(HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);

        CareerVo careerVo = new CareerVo();
        PaginationVo paginationVo = new PaginationVo();
        CareerPageViewBo pageViewBo = null;
        CareerPageViewVo pageViewVo = null;
        try {
            pageViewBo = generalFacade.queryCareer(CareerConverter.fromModel(careerVo), PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CareerPageViewConverter.toModel(pageViewBo);
        if (pageViewVo.getData() != null) {
            ArrayList<CareerVo> treeList = (ArrayList<CareerVo>) TreeParser.parse(pageViewVo.getData());
            pageViewVo.setData(treeList);
        }

        return pageViewVo;
    }

}
