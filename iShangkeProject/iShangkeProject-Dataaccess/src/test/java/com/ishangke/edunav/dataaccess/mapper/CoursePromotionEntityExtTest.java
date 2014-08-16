package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CoursePromotionEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CoursePromotionEntityExtTest {
    @Autowired
    private CoursePromotionEntityExtMapper CoursePromotionEntityExtMapper;
    
    private Calendar time = Calendar.getInstance();
    
    @Test
    public void testQuery() {

        CoursePromotionEntityExt coursePromotionEntityExt = new CoursePromotionEntityExt();
        coursePromotionEntityExt.setStatus(1);

        List<CoursePromotionEntityExt> result = CoursePromotionEntityExtMapper.list(coursePromotionEntityExt, null);
    }
   
   

}
