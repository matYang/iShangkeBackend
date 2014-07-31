package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
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
}
