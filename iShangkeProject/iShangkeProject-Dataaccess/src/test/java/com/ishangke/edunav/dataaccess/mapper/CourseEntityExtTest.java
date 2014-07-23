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
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseEntityExtTest extends BaseTest {
    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    // public CourseEntityExtTest() {
    // scriptAfterClass = "CourseEntityExtTestAfter.sql";
    // scriptBeforeClass = "CourseEntityExtTestBefore.sql";
    // }

    @Test
    public void testAdd() {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseEntityExt.setEnabled(1);
        courseEntityExt.setDeleted(0);
        courseEntityExt.setAddressId(1);
        courseEntityExt.setCategoryId(1);
        courseEntityExt.setCircleId(1);
        courseEntityExt.setCourseTemplateId(1);
        courseEntityExt.setLocationId(1);
        courseEntityExt.setPartnerId(1);
        courseEntityExtMapper.add(courseEntityExt);
        int oldcount = courseEntityExtMapper.getCount();
        courseEntityExtMapper.add(courseEntityExt);
        Assert.assertSame(courseEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseEntityExt.setEnabled(1);
        courseEntityExt.setDeleted(0);
        courseEntityExt.setAddressId(1);
        courseEntityExt.setCategoryId(1);
        courseEntityExt.setCircleId(1);
        courseEntityExt.setCourseTemplateId(1);
        courseEntityExt.setLocationId(1);
        courseEntityExt.setPartnerId(1);
        courseEntityExtMapper.add(courseEntityExt);
        int oldcount = courseEntityExtMapper.getCount();
        courseEntityExtMapper.deleteById(courseEntityExt.getId());
        Assert.assertSame(courseEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("CUTOFF_DATE",
                DataaccessConstants.ORDER_ASC));

        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCategoryValue("0001");
        List<CourseEntityExt> result = courseEntityExtMapper.list(
                courseEntityExt, null);
        System.out.println("count:" + result.size());
        for (CourseEntityExt c : result) {
            System.out.println(c.getCourseName() + "===>"
                    + c.getCategoryValue());
        }
        Assert.assertSame(courseEntityExtMapper.getListCount(courseEntityExt),
                result.size());
        // Assert.assertEquals(5, result.size());
        // Assert.assertEquals("雅思05", result.get(0).getCourseName());
    }

    @Test
    public void testQuery1() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(80);

        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("CUTOFF_DATE",
                DataaccessConstants.ORDER_ASC));

        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCategoryValue("010000");
        courseEntityExt.setCircleValue("01");
        courseEntityExt.setLocationValue("000004");
        List<CourseEntityExt> result = courseEntityExtMapper.list(
                courseEntityExt, page);
        System.out.println("count:" + result.size());
        for (CourseEntityExt c : result) {
            System.out.println(c.getCourseName() + "===>"
                    + DateUtility.toSQLDateTime(c.getLastModifyTime()));
        }
        Assert.assertSame(courseEntityExtMapper.getListCount(courseEntityExt),
                result.size());
        // Assert.assertEquals(5, result.size());
        // Assert.assertEquals("雅思05", result.get(0).getCourseName());
    }

    @Test
    public void testQuery10() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(80);

        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("CUTOFF_DATE",
                DataaccessConstants.ORDER_ASC));

        CourseEntityExt courseEntityExt = new CourseEntityExt();

        courseEntityExt.setLocationValue("");
        courseEntityExt.setCircleValue("");
        courseEntityExt.setCategoryValue("");
        courseEntityExt.setPriceStart(1000.0);
        courseEntityExt.setPriceEnd(3000.0);
        List<CourseEntityExt> result = courseEntityExtMapper.list(
                courseEntityExt, page);
        System.out.println("count:" + result.size());
        for (CourseEntityExt c : result) {
            System.out.println(c.getCourseName() + "===>"
                    + DateUtility.toSQLDateTime(c.getLastModifyTime()) + "===>" + c.getPrice());
        }
        Assert.assertSame(courseEntityExtMapper.getListCount(courseEntityExt),
                result.size());
        // Assert.assertEquals(5, result.size());
        // Assert.assertEquals("雅思05", result.get(0).getCourseName());
    }

    @Test
    public void testQuery2() {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseEntityExt.setIdSet(idSet);
        List<CourseEntityExt> result = courseEntityExtMapper.list(
                courseEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testGet() {
        CourseEntityExt getbyid1 = courseEntityExtMapper.getInfoById(2);
        CourseEntityExt getbyid2 = courseEntityExtMapper.getInfoById(3);
        CourseEntityExt getbyid3 = courseEntityExtMapper.getInfoById(4);
        Assert.assertEquals("雅思02", getbyid1.getCourseName());
        Assert.assertEquals("雅思03", getbyid2.getCourseName());
        Assert.assertEquals("雅思04", getbyid3.getCourseName());

    }

    @Test
    public void testUpdate() {
        CourseEntityExt upDate = courseEntityExtMapper.getInfoById(2);
        upDate.setCourseName("test_爱上课");
        upDate.setAssignments("test_ishangke");
        upDate.setCreateTime(time);
        courseEntityExtMapper.update(upDate);
        upDate = courseEntityExtMapper.getInfoById(2);
        Assert.assertEquals("test_爱上课", upDate.getCourseName());
        Assert.assertEquals("test_ishangke", upDate.getAssignments());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }

}
