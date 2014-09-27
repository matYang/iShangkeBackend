package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class GroupBuyPhotoEntityExtTest {
    @Autowired
    private GroupBuyPhotoEntityExtMapper groupBuyPhotoEntityExtMapper;
    
    @Test
    public void testAdd(){
        GroupBuyPhotoEntityExt groupBuyPhoto = new GroupBuyPhotoEntityExt();
        groupBuyPhoto.setUrl("1");
        groupBuyPhoto.setGroupBuyActivityId(1);
        int count = groupBuyPhotoEntityExtMapper.add(groupBuyPhoto);
        Assert.assertSame(1, count);
    }
    
    @Test
    public void testUpdate(){
        GroupBuyPhotoEntityExt groupBuyPhotoOld = groupBuyPhotoEntityExtMapper.getById(1);
        int activityOld = groupBuyPhotoOld.getGroupBuyActivityId();
        Assert.assertSame(1, activityOld);
        groupBuyPhotoOld.setGroupBuyActivityId(2);
        groupBuyPhotoEntityExtMapper.update(groupBuyPhotoOld);
        GroupBuyPhotoEntityExt groupBuyPhotoNew = groupBuyPhotoEntityExtMapper.getById(1);
        int activityNew = groupBuyPhotoNew.getGroupBuyActivityId();
        Assert.assertSame(2, activityNew);
    }
    
    @Test
    public void testDelete(){
        groupBuyPhotoEntityExtMapper.deleteById(4);
        GroupBuyPhotoEntityExt object = groupBuyPhotoEntityExtMapper.getById(4);
        Assert.assertSame(object, null);
    }
    
    @Test
    public void testList(){
        GroupBuyPhotoEntityExt groupBuyPhoto = new GroupBuyPhotoEntityExt();
        groupBuyPhoto.setGroupBuyActivityId(1);
        List<GroupBuyPhotoEntityExt> list = groupBuyPhotoEntityExtMapper.list(groupBuyPhoto, null);
        int countFirst = list.size();
        int countSecond = groupBuyPhotoEntityExtMapper.getListCount(groupBuyPhoto);
        Assert.assertSame(countFirst, countSecond);
    }
}
