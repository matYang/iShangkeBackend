package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseClassPhotoEntityExtTest extends BaseTest{
    @Autowired
    private CourseClassPhotoEntityExtMapper courseClassPhotoEntityExtMapper;
    public  CourseClassPhotoEntityExtTest() {
        scriptAfterClass = "CourseClassPhotoEntityExtTestAfter.sql";
        scriptBeforeClass = "CourseClassPhotoEntityExtTestBefore.sql";
    }
    @Test
    public void testAdd() {
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        courseClassPhotoEntityExt.setCreateTime(new Date());
        courseClassPhotoEntityExt.setDeleted(0);
        courseClassPhotoEntityExt.setClassPhotoId(1);
        courseClassPhotoEntityExt.setCourseId(1);
        courseClassPhotoEntityExtMapper.add(courseClassPhotoEntityExt);
        int oldcount = courseClassPhotoEntityExtMapper.getCount();
        courseClassPhotoEntityExtMapper.add(courseClassPhotoEntityExt);
        Assert.assertSame(courseClassPhotoEntityExtMapper.getCount(),
                oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        courseClassPhotoEntityExt.setCreateTime(new Date());
        courseClassPhotoEntityExt.setDeleted(0);
        courseClassPhotoEntityExt.setClassPhotoId(1);
        courseClassPhotoEntityExt.setCourseId(1);
        courseClassPhotoEntityExtMapper.add(courseClassPhotoEntityExt);
        int oldcount = courseClassPhotoEntityExtMapper.getCount();
        courseClassPhotoEntityExtMapper.deleteById(courseClassPhotoEntityExt
                .getId());
        Assert.assertSame(courseClassPhotoEntityExtMapper.getCount(),
                oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CourseClassPhotoEntityExt courseClassPhotoQueryEntity = new CourseClassPhotoEntityExt();
        courseClassPhotoQueryEntity.setClassPhotoId(1);
        List<CourseClassPhotoEntityExt> result = courseClassPhotoEntityExtMapper.list(courseClassPhotoQueryEntity, page);
        Assert.assertEquals(3, result.size());
        //Assert.assertEquals("_test_CourseTemplateClassPhotos_2_", result.get(0).getCreateTime());
    }

}
