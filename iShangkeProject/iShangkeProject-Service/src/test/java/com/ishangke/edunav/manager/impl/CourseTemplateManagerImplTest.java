package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class CourseTemplateManagerImplTest extends BaseTest {
    @Autowired
    private CourseTemplateManager courseTemplateManager;
    
    @Autowired
    private CourseTemplateEntityExtMapper courseMapper;
    
    @Autowired
    private UserEntityExtMapper userMapper;
    
    @Autowired
    private PartnerEntityExtMapper partnerMapper;
    
    @Test(expected = ManagerException.class)
    public void testCourseTemplate() {
        CourseTemplateBo courseTemplate = new CourseTemplateBo();
        courseTemplate.setCategoryId(1);
        courseTemplate.setLocationId(1);
        courseTemplate.setCircleId(1);
        courseTemplate.setPartnerId(2);
        courseTemplate.setAddress("suioeuaoiasijdiaosujiowqh");
        
        UserEntityExt user = userMapper.getById(6);
        
        courseTemplateManager.createCourseTemplate(courseTemplate,  UserConverter.toBo(user));
    }
    
    @Test
    public void testCourseTemplate2() {
        CourseTemplateBo courseTemplate = new CourseTemplateBo();
        courseTemplate.setCategoryId(1);
        courseTemplate.setLocationId(1);
        courseTemplate.setCircleId(1);
        courseTemplate.setPartnerId(2);
        courseTemplate.setAddressId(1);
        
        TeacherBo t = new TeacherBo();
        t.setId(5);
        //5
        List<TeacherBo> l = new ArrayList<>();
        l.add(t);
        courseTemplate.setTeacherList(l);
        UserEntityExt user = userMapper.getById(4);
        
        PartnerEntityExt partner = partnerMapper.getById(2);
        
        courseTemplateManager.createCourseTemplate(courseTemplate, UserConverter.toBo(user));
    }
    
    @Test
    public void testCourseTempalet() {
        CourseTemplateBo courseTemplate = new CourseTemplateBo();
        courseTemplate.setCategoryId(1);
        courseTemplate.setLocationId(1);
        courseTemplate.setCircleId(1);
        courseTemplate.setPartnerId(2);
        courseTemplate.setAddressId(1);
        courseTemplate.setStatus(2);
        courseTemplate.setCourseName("");
        
        CourseTemplateEntityExt course = CourseTemplateConverter.fromBo(courseTemplate);
        int id = courseMapper.add(course);
        System.out.println("ghuiyuihguihiujkhjlkhjkl" + id);
        courseTemplate.setId(course.getId());
        
        UserEntityExt user = userMapper.getById(4);
        
        courseTemplateManager.transformCourseTmeplateStatus(courseTemplate, 3, UserConverter.toBo(user));
    }
}
