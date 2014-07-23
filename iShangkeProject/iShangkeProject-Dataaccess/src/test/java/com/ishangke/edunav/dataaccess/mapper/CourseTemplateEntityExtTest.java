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

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateEntityExtTest extends BaseTest {
    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateEntityExtMapper;
    private Calendar time = Calendar.getInstance();
//    public CourseTemplateEntityExtTest() {
//        scriptAfterClass = "CourseTemplateEntityExtTestAfter.sql";
//        scriptBeforeClass = "CourseTemplateEntityExtTestBefore.sql";
//    }

    @Test
    public void testAdd() {
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        courseTemplateEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseTemplateEntityExt.setEnabled(1);
        courseTemplateEntityExt.setDeleted(0);
        courseTemplateEntityExt.setAddressId(1);
        courseTemplateEntityExt.setCategoryId(1);
        courseTemplateEntityExt.setCircleId(1);
        courseTemplateEntityExt.setLocationId(1);
        courseTemplateEntityExt.setPartnerId(1);
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        int oldcount = courseTemplateEntityExtMapper.getCount();
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        Assert.assertSame(courseTemplateEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        courseTemplateEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseTemplateEntityExt.setEnabled(1);
        courseTemplateEntityExt.setDeleted(0);
        courseTemplateEntityExt.setAddressId(1);
        courseTemplateEntityExt.setCategoryId(1);
        courseTemplateEntityExt.setCircleId(1);
        courseTemplateEntityExt.setLocationId(1);
        courseTemplateEntityExt.setPartnerId(1);
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        int oldcount = courseTemplateEntityExtMapper.getCount();
        courseTemplateEntityExtMapper.deleteById(courseTemplateEntityExt.getId());
        Assert.assertSame(courseTemplateEntityExtMapper.getCount(), oldcount - 1);
    }

//    @Test
//    public void testQuery() {
//        PaginationEntity page = new PaginationEntity();
//        page.setOffset(0);
//        page.setSize(10);
//
//        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
//        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
//        page.addOrderByEntity(new OrderByEntity("CUTOFF_DATE", DataaccessConstants.ORDER_ASC));
//        
//        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
//        courseTemplateEntityExt.setCourseName("_test_ct_");
//        
//        List<CourseTemplateEntityExt> result = null;
//        //long startTime = System.nanoTime();
//        //for (int i = 0; i < 1000; i++){
//            result = courseTemplateEntityExtMapper.list(courseTemplateEntityExt, page);
//        //}
//        //System.out.println("==================finish time: " + (System.nanoTime() - startTime));
//        Assert.assertEquals(3, result.size());
//        //Assert.assertEquals("_test_ct_爱上课英语课（上的都牛逼）", result.get(2).getCourseName());
//    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

       
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("CUTOFF_DATE", DataaccessConstants.ORDER_ASC));
        
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        courseTemplateEntityExt.setCourseName("雅思");

        List<CourseTemplateEntityExt> result = courseTemplateEntityExtMapper.list(courseTemplateEntityExt, page);
        Assert.assertEquals(5, result.size());
        Assert.assertEquals("雅思05", result.get(0).getCourseName());
    }
    @Test
    public void testQuery2() {
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseTemplateEntityExt.setIdSet(idSet);
        List<CourseTemplateEntityExt> result = courseTemplateEntityExtMapper.list(courseTemplateEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
   
   
    @Test
    public void testGet() {
        CourseTemplateEntityExt getbyid1 = courseTemplateEntityExtMapper
                .getInfoById(2);
        CourseTemplateEntityExt getbyid2 = courseTemplateEntityExtMapper
                .getInfoById(3);
        CourseTemplateEntityExt getbyid3 = courseTemplateEntityExtMapper
                .getInfoById(4);
        Assert.assertEquals("雅思02", getbyid1.getCourseName());
        Assert.assertEquals("雅思03", getbyid2.getCourseName());
        Assert.assertEquals("雅思04", getbyid3.getCourseName());
        
       
    }
    @Test
    public void testUpdate() {
        CourseTemplateEntityExt upDate = courseTemplateEntityExtMapper
                .getInfoById(2);
        upDate.setCourseName("test_爱上课");
        upDate.setAssignments("test_ishangke");
        upDate.setCreateTime(time);
        courseTemplateEntityExtMapper.update(upDate);
        upDate = courseTemplateEntityExtMapper.getInfoById(2);
        Assert.assertEquals("test_爱上课", upDate.getCourseName());
        Assert.assertEquals("test_ishangke", upDate.getAssignments());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
