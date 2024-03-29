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
public class CourseController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryCourse(CourseVo courseVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        if (req.getHeader("referer") == null || !req.getHeader("referer").contains("ishangke.cn")) {
            JsonResponse err = new JsonResponse();
            err.setMessage("sorry~ you can not query our course by api directly~");
            return err;
        }
        String permissionTag = this.getUrl(req);

        CoursePageViewBo pageViewBo = null;
        CoursePageViewVo pageViewVo = null;
        List<OrderByVo> listOrder = new ArrayList<>();
        String columnKey = "";
        String order = "";
        if (CourseMap.COURSE_MAP.get(paginationVo.getColumnKey()) != null && CourseMap.COURSE_MAP.get(paginationVo.getOrder()) != null) {
            columnKey = paginationVo.getColumnKey();
            order = paginationVo.getOrder();
            listOrder.add(new OrderByVo(CourseMap.COURSE_MAP.get(paginationVo.getColumnKey()), CourseMap.COURSE_MAP.get(paginationVo.getOrder())));
        }
        listOrder.add(new OrderByVo("POPULARITY", "DESC"));
        paginationVo.setOrderByEntities(listOrder);
        paginationVo.setColumnKey(null);
        paginationVo.setOrder(null);
        //每次最多拉去20条course数据 后面再换更好的实现方式
        if (paginationVo.getStart() == null || paginationVo.getCount() == null || (paginationVo.getCount() != null && paginationVo.getCount() > 20)) {
            paginationVo.setStart(0);
            paginationVo.setCount(20);
        }
        try {
            pageViewBo = courseFacade.queryCourseByFilter(CourseConverter.fromModel(courseVo), PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CoursePageViewConverter.toModel(pageViewBo);
        // 课程曝光次数
        if (courseVo.getIdSet() == null && pageViewVo.getData() != null) {
            String shine = "";
            for (CourseVo c : pageViewVo.getData()) {
                shine = shine + c.getId() + ",";
            }
            LOGGER.info("[shine]" + shine);
        }
        String category = courseVo.getCategoryValue() == null ? "" : courseVo.getCategoryValue();
        String idSet = courseVo.getIdSet() == null ? "" : courseVo.getIdSet().toString();
        LOGGER.info("[queryCourse]:category:" + category + ";idSet:" + idSet + ";ColumnKey:" + columnKey + ";Order:" + order);
        return pageViewVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse queryCourseById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        if (req.getHeader("referer") == null || !req.getHeader("referer").contains("ishangke.cn")) {
            JsonResponse err = new JsonResponse();
            err.setMessage("sorry~ you can not query our course by api directly~");
            return err;
        }
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
