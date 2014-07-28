package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseClassPhotoEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseClassPhotoEntityExtTest{
    @Autowired
    private CourseClassPhotoEntityExtMapper courseClassPhotoEntityExtMapper;
    private Calendar time = Calendar.getInstance();
//    public  CourseClassPhotoEntityExtTest() {
//        scriptAfterClass = "CourseClassPhotoEntityExtTestAfter.sql";
//        scriptBeforeClass = "CourseClassPhotoEntityExtTestBefore.sql";
//    }
    @Test
    public void testAdd() {
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
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
        courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
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
        courseClassPhotoQueryEntity.setCourseId(1);
        List<CourseClassPhotoEntityExt> result = courseClassPhotoEntityExtMapper.list(courseClassPhotoQueryEntity, page);
        Assert.assertEquals(1, result.size());
        //Assert.assertEquals("_test_CourseTemplateClassPhotos_2_", result.get(0).getCreateTime());
    }
    @Test
    public void testQuery2() {
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseClassPhotoEntityExt.setIdSet(idSet);
        List<CourseClassPhotoEntityExt> result = courseClassPhotoEntityExtMapper.list(courseClassPhotoEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        courseClassPhotoEntityExt.setCourseId(4);
      
        List<CourseClassPhotoEntityExt> result = courseClassPhotoEntityExtMapper.list(courseClassPhotoEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(3, result.get(0).getClassPhotoId());
    }
    @Test
    public void testGet() {
        CourseClassPhotoEntityExt getbyid1 = courseClassPhotoEntityExtMapper
                .getById(2);
        CourseClassPhotoEntityExt getbyid2 = courseClassPhotoEntityExtMapper
                .getById(3);
        CourseClassPhotoEntityExt getbyid3 = courseClassPhotoEntityExtMapper
                .getById(4);
        String time = "2014-07-15 15:07:16";
        Assert.assertEquals(time, DateUtility.toSQLDateTime(getbyid1.getCreateTime()));
       
//        Assert.assertEquals("_test_remark_2_爱上课", getbyid2.getRemark());
//        Assert.assertEquals("_test_remark_3_爱上课", getbyid3.getRemark());
    }
    @Test
    public void testUpdate() {
        CourseClassPhotoEntityExt upDate = courseClassPhotoEntityExtMapper
                .getById(2);
        upDate.setClassPhotoId(3);
       
        upDate.setCreateTime(time);
        courseClassPhotoEntityExtMapper.update(upDate);
        upDate = courseClassPhotoEntityExtMapper.getById(2);
      
        Assert.assertSame(3, upDate.getClassPhotoId());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
