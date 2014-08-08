package com.ishangke.edunav.web.admin.controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.CourseFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CourseCommentConverter;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CourseCommentPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CourseCommentVo;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.pageview.CourseCommentPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;


@Controller
@RequestMapping("/a-api/v2/comment")

public class CommentController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    CourseFacade courseFacade;
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody CourseCommentVo create(@RequestBody CourseCommentVo courseCommentVo, HttpServletRequest req, HttpServletResponse resp) {
        CourseCommentVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CourseCommentBo targetCourseComment = CourseCommentConverter.fromModel(courseCommentVo);
        
        CourseCommentBo responseCourseComment = courseFacade.commentCourse(targetCourseComment, curUser, permissionTag);
        responseVo = CourseCommentConverter.toModel(responseCourseComment);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = "application/json")
    public @ResponseBody EmptyResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
          
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CourseCommentVo courseCommentVo = new CourseCommentVo();
        courseCommentVo.setId(id);
        CourseCommentBo targetCourseComment = CourseCommentConverter.fromModel(courseCommentVo);
        
        courseFacade.deleteCommentByCommentId(targetCourseComment, curUser, permissionTag);
        return new EmptyResponse();
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CourseCommentPageViewVo  queryCourseComment(CourseCommentVo courseCommentVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CourseCommentPageViewBo pageViewBo = null;
        CourseCommentPageViewVo pageViewVo = null;
        
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseTemplateId(courseCommentVo.getCourseTemplateId());
        CourseBo targetCourse = CourseConverter.fromModel(courseVo);
        
        pageViewBo = courseFacade.queryCommentByCourseId(targetCourse, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = CourseCommentPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
}
