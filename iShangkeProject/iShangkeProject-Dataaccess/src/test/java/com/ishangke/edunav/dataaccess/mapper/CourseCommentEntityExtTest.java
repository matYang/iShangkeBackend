package com.ishangke.edunav.dataaccess.mapper;

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

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseCommentEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseCommentEntityExtTest {
    @Autowired
    private CourseCommentEntityExtMapper courseCommentEntityExtMapper;
//    public  CourseCommentEntityExtTest() {
//        scriptAfterClass = "CourseCommentEntityExtTestAfter.sql";
//        scriptBeforeClass = "CourseCommentEntityExtTestBefore.sql";
//    }
    @Test
    public void testAdd() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        courseCommentEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseCommentEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseCommentEntityExt.setEnabled(1);
        courseCommentEntityExt.setDeleted(0);
        courseCommentEntityExt.setUserId(1);
        courseCommentEntityExt.setCourseTemplateId(1);
     
        courseCommentEntityExtMapper.add(courseCommentEntityExt);
        int oldcount = courseCommentEntityExtMapper.getCount();
        courseCommentEntityExtMapper.add(courseCommentEntityExt);
        Assert.assertSame(courseCommentEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        courseCommentEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseCommentEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseCommentEntityExt.setEnabled(1);
        courseCommentEntityExt.setDeleted(0);
        courseCommentEntityExt.setUserId(1);
        courseCommentEntityExt.setCourseTemplateId(1);
        courseCommentEntityExtMapper.add(courseCommentEntityExt);
        int oldcount = courseCommentEntityExtMapper.getCount();
        courseCommentEntityExtMapper.deleteById(courseCommentEntityExt.getId());
        Assert.assertSame(courseCommentEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CourseCommentEntityExt courseCommentQueryEntity = new CourseCommentEntityExt();
        courseCommentQueryEntity.setTitle("_test_title_");
        List<CourseCommentEntityExt> result = courseCommentEntityExtMapper.list(courseCommentQueryEntity, page);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_title_1_爱上课", result.get(0).getTitle());
    }
    @Test
    public void testQuery2() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseCommentEntityExt.setIdSet(idSet);
        List<CourseCommentEntityExt> result = courseCommentEntityExtMapper.list(courseCommentEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        courseCommentEntityExt.setUserId(2);
      
        List<CourseCommentEntityExt> result = courseCommentEntityExtMapper.list(courseCommentEntityExt, page);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("_test_title_1_爱上课", result.get(0).getTitle());
        Assert.assertEquals("_test_title_3_爱上课", result.get(1).getTitle());
    }
    
    @Test
    public void testQuery4() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        courseCommentEntityExt.setUserId(2);
        courseCommentEntityExt.setCourseTemplateId(4);
        List<CourseCommentEntityExt> result = courseCommentEntityExtMapper.list(courseCommentEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_title_3_爱上课", result.get(0).getTitle());
    }
    @Test
    public void testGet() {
        CourseCommentEntityExt getbyid1 = courseCommentEntityExtMapper
                .getById(2);
        CourseCommentEntityExt getbyid2 = courseCommentEntityExtMapper
                .getById(3);
        CourseCommentEntityExt getbyid3 = courseCommentEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_title_1_爱上课", getbyid1.getTitle());
        Assert.assertEquals("_test_title_2_爱上课", getbyid2.getTitle());
        Assert.assertEquals("_test_title_3_爱上课", getbyid3.getTitle());
        
       
    }

}
