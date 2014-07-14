package com.ishangke.edunav.dataaccess.mapper;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ClassPhotoEntityExtTest extends BaseTest{
    @Autowired
    private ClassPhotoEntityExtMapper classPhotoEntityExtMapper;
    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateEntityExtMapper;
    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;
    @Autowired
    private CourseClassPhotoEntityExtMapper courseClassPhotoEntityExtMapper;
    @Autowired
    private CourseTemplateClassPhotoEntityExtMapper courseTemplateClassPhotoEntityExtMapper;
    
    @Test
    public void testAdd() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int oldcount = classPhotoEntityExtMapper.getCount();
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        Assert.assertSame(classPhotoEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int oldcount = classPhotoEntityExtMapper.getCount();
        classPhotoEntityExtMapper.deleteById(classPhotoEntityExt.getId());
        Assert.assertSame(classPhotoEntityExtMapper.getCount(), oldcount - 1);
    }
    
    @Test
    public void testList(){        
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setPartnerId(1);        
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);     
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int classPhotoId = classPhotoEntityExt.getId();
        
        List<ClassPhotoEntityExt> list = classPhotoEntityExtMapper.list(classPhotoEntityExt, null);
        Assert.assertSame(list.size(),1);
        
        int listSize = classPhotoEntityExtMapper.getListCount(classPhotoEntityExt);
        Assert.assertSame(listSize,1);
        
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = classPhotoEntityExtMapper.list(classPhotoEntityExt, page);
        Assert.assertSame(list.size(),1);
        
        
        /* Get By PartnerId */
        list = classPhotoEntityExtMapper.listClassPhotoByPartnerId(1);
        Assert.assertSame(list.size(),2);
              
        @SuppressWarnings("unused")
        List<ClassPhotoEntityExt> clist = null;
        /* Get By CourseId */
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();      
        courseTemplateEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseTemplateEntityExt.setCategoryId(1);
        courseTemplateEntityExt.setLocationId(1);
        courseTemplateEntityExt.setCircleId(1);
        courseTemplateEntityExt.setPartnerId(1);
        courseTemplateEntityExt.setAddressId(1);
        courseTemplateEntityExt.setEnabled(1);
        courseTemplateEntityExt.setDeleted(0);
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        int courseTemplateId = courseTemplateEntityExt.getId();
        
        CourseEntityExt courseEntityExt = new CourseEntityExt();     
        courseEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseEntityExt.setCourseTemplateId(courseTemplateId);
        courseEntityExt.setCategoryId(1);
        courseEntityExt.setLocationId(1);
        courseEntityExt.setCircleId(1);
        courseEntityExt.setPartnerId(1);
        courseEntityExt.setAddressId(1);
        courseEntityExt.setEnabled(1);
        courseEntityExt.setDeleted(0);
        courseEntityExtMapper.add(courseEntityExt);
        int courseId = courseEntityExt.getId();
        
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        courseClassPhotoEntityExt.setCourseId(courseId);
        courseClassPhotoEntityExt.setClassPhotoId(classPhotoId);
        courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseClassPhotoEntityExt.setDeleted(0);
        courseClassPhotoEntityExtMapper.add(courseClassPhotoEntityExt);
        
        list = classPhotoEntityExtMapper.listClassPhotoByCourseId(courseId);
        Assert.assertSame(list.size(),1);
        
        /* Get By CourseTemplateId */
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(courseTemplateId);
        courseTemplateClassPhotoEntityExt.setClassPhotoId(classPhotoId);
        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateClassPhotoEntityExt.setDeleted(0);
        courseTemplateClassPhotoEntityExtMapper.add(courseTemplateClassPhotoEntityExt);
        
        list = classPhotoEntityExtMapper.listClassPhotoByCourseTempleteId(courseTemplateId);
        Assert.assertSame(list.size(),1);      
        
    }
    
    @Test
    public void testUpdate(){
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        
        
        List<ClassPhotoEntityExt> list = classPhotoEntityExtMapper.list(classPhotoEntityExt, null);
        String name = "李清";
        list.get(0).setImgUrl(name);
        
        classPhotoEntityExtMapper.update(list.get(0));
        list = classPhotoEntityExtMapper.list(list.get(0), null);
        if(list.get(0).getImgUrl().equals(name)){
            //Passed;
        }else fail();
    }

}
