package com.ishangke.edunav.web.user.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ishangke.edunav.facade.user.CourseFacade;
import com.ishangke.edunav.web.user.controller.AbstractController;



@Controller
@RequestMapping("/api/v2/course")

public class CourseController  extends AbstractController{
    
    @Autowired
    CourseFacade courseFacade;
    
    

}
