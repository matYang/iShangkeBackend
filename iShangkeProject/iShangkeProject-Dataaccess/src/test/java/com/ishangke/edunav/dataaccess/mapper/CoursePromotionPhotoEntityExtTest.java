package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CoursePromotionPhotoEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CoursePromotionPhotoEntityExtTest {
    @Autowired
    private CoursePromotionPhotoEntityExtMapper coursePromotionPhotoEntityExtMapper;
    
    @Test
    public void testAdd(){
        CoursePromotionPhotoEntityExt coursePromotionPhoto = new CoursePromotionPhotoEntityExt();
        coursePromotionPhoto.setUrl("1");
        coursePromotionPhoto.setCoursePromotionId(1);
        int count = coursePromotionPhotoEntityExtMapper.add(coursePromotionPhoto);
        Assert.assertSame(1, count);
    }
    
    @Test
    public void testUpdate(){
        CoursePromotionPhotoEntityExt coursePromotionPhotoOld = coursePromotionPhotoEntityExtMapper.getById(1);
        int activityOld = coursePromotionPhotoOld.getCoursePromotionId();
        Assert.assertSame(1, activityOld);
        coursePromotionPhotoOld.setCoursePromotionId(2);
        coursePromotionPhotoEntityExtMapper.update(coursePromotionPhotoOld);
        CoursePromotionPhotoEntityExt coursePromotionPhotoNew = coursePromotionPhotoEntityExtMapper.getById(1);
        int activityNew = coursePromotionPhotoNew.getCoursePromotionId();
        Assert.assertSame(2, activityNew);
    }
    
    @Test
    public void testDelete(){
        coursePromotionPhotoEntityExtMapper.deleteById(4);
        CoursePromotionPhotoEntityExt object = coursePromotionPhotoEntityExtMapper.getById(4);
        Assert.assertSame(object, null);
    }
    
    @Test
    public void testList(){
        CoursePromotionPhotoEntityExt coursePromotionPhoto = new CoursePromotionPhotoEntityExt();
        coursePromotionPhoto.setCoursePromotionId(1);
        List<CoursePromotionPhotoEntityExt> list = coursePromotionPhotoEntityExtMapper.list(coursePromotionPhoto, null);
        int countFirst = list.size();
        int countSecond = coursePromotionPhotoEntityExtMapper.getListCount(coursePromotionPhoto);
        Assert.assertSame(countFirst, countSecond);
    }
    
    @Test
    public void testDelete1() {
        CoursePromotionPhotoEntityExt coursePromotionPhoto = new CoursePromotionPhotoEntityExt();
        coursePromotionPhoto.setCoursePromotionId(2);
        List<CoursePromotionPhotoEntityExt> listOld = coursePromotionPhotoEntityExtMapper.list(coursePromotionPhoto, null);
        coursePromotionPhotoEntityExtMapper.deleteByCoursePromotionId(2);
        List<CoursePromotionPhotoEntityExt> listNew = coursePromotionPhotoEntityExtMapper.list(coursePromotionPhoto, null);
        Assert.assertSame(2, listOld.size());
        Assert.assertSame(0, listNew.size());
    }
}
