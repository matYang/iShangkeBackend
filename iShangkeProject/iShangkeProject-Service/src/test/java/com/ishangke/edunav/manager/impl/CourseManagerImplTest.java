package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.CourseManager;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class CourseManagerImplTest {
    @Autowired
    private CourseManager courseManager;
    
    @Test
    public void testCategory() {
        List<CategoryBo> result = courseManager.queryCategoryByKeyword("四");
        System.out.println(result.size());
    }
    
    @Test
    public void testCommentCourse() {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        courseCommentBo.setUserId(6);
        courseCommentBo.setCourseTemplateId(6);
        courseCommentBo.setTitle("6");
        courseCommentBo.setContent("6");
        courseCommentBo.setAttitudeRating(6.0);
        courseCommentBo.setConditionRating(4.0);
        courseCommentBo.setSatisfactionRating(8.0);
        courseCommentBo.setLastModifyTime(DateUtility.getCurTime());
        courseCommentBo.setCreateTime(DateUtility.getCurTime());
        UserBo userBo = new UserBo();
        userBo.setId(6);
        CourseCommentBo bo = courseManager.commentCourse(courseCommentBo, userBo);
        Assert.assertSame(6, bo.getCourseTemplateId());
    }
    
    @Test
    public void testQueryCommentByCourseId(){
        CourseBo courseBo = new CourseBo();
        courseBo.setId(1);
        List<CourseCommentBo> list = courseManager.queryCommentByCourseId(courseBo, null);
        Assert.assertSame(1, list.size());
        String content = list.get(0).getContent();
        Assert.assertEquals("1", content);
    }
}
