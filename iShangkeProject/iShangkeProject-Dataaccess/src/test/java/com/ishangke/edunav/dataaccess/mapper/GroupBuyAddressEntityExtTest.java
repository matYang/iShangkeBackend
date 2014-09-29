package com.ishangke.edunav.dataaccess.mapper;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.GroupBuyAddressEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class GroupBuyAddressEntityExtTest {
    @Autowired
    private GroupBuyAddressEntityExtMapper groupBuyAddressEntityExtMapper;
    
    @Test
    public void testAdd(){
        GroupBuyAddressEntityExt groupBuyAddress = new GroupBuyAddressEntityExt();
        groupBuyAddress.setAddressId(1);
        groupBuyAddress.setGroupBuyActivityId(1);
        int count = groupBuyAddressEntityExtMapper.add(groupBuyAddress);
        Assert.assertSame(1, count);
    }
    
    @Test
    public void testUpdate(){
        GroupBuyAddressEntityExt groupBuyAddressOld = groupBuyAddressEntityExtMapper.getById(1);
        int addressOld = groupBuyAddressOld.getAddressId();
        Assert.assertSame(1, addressOld);
        groupBuyAddressOld.setAddressId(2);
        groupBuyAddressEntityExtMapper.update(groupBuyAddressOld);
        GroupBuyAddressEntityExt groupBuyAddressNew = groupBuyAddressEntityExtMapper.getById(1);
        int addressNew = groupBuyAddressNew.getAddressId();
        Assert.assertSame(2, addressNew);
    }
    
    @Test
    public void testDelete(){
        groupBuyAddressEntityExtMapper.deleteById(4);
        GroupBuyAddressEntityExt object = groupBuyAddressEntityExtMapper.getById(4);
        Assert.assertSame(object, null);
    }

    @Test
    public void testDeleteByGroupBuyActivityId() {
        int result = groupBuyAddressEntityExtMapper.deleteByGroupBuyActivityId(1);
        assertTrue(result > 0);
    }

    @Test
    public void testList(){
        GroupBuyAddressEntityExt groupBuyAddress = new GroupBuyAddressEntityExt();
        groupBuyAddress.setGroupBuyActivityId(1);
        List<GroupBuyAddressEntityExt> list = groupBuyAddressEntityExtMapper.list(groupBuyAddress, null);
        int countFirst = list.size();
        int countSecond = groupBuyAddressEntityExtMapper.getListCount(groupBuyAddress);
        Assert.assertSame(countFirst, countSecond);
    }
}
