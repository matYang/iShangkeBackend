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
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseCommentEntityExtTest extends BaseTest{
    @Autowired
    private CourseCommentEntityExtMapper courseCommentEntityExtMapper;
    public  CourseCommentEntityExtTest() {
        scriptAfterClass = "CourseCommentEntityExtTestAfter.sql";
        scriptBeforeClass = "CourseCommentEntityExtTestBefore.sql";
    }
    @Test
    public void testAdd() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        courseCommentEntityExt.setCreateTime(new Date());
        courseCommentEntityExt.setLastModifyTime(new Date());
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
        courseCommentEntityExt.setCreateTime(new Date());
        courseCommentEntityExt.setLastModifyTime(new Date());
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
        Assert.assertEquals(3, result.size());
        //Assert.assertEquals("_test_CourseTemplateClassPhotos_2_", result.get(0).getCreateTime());
    }

}
