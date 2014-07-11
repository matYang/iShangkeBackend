package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class AddressEntityExtTest {
    @Autowired
    private AddressEntityExtMapper addressEntityExtMapper;

    @Test
    public void testAdd() {
        AddressEntityExt addressEntityExt = new AddressEntityExt();
        addressEntityExt.setCreateTime(new Date());
        addressEntityExt.setLastModifyTime(new Date());
        addressEntityExt.setEnabled(1);
        addressEntityExt.setDeleted(0);
        addressEntityExt.setCircleId(1);
        addressEntityExt.setLocationId(1);
        addressEntityExt.setPartnerId(1);
        addressEntityExt.setDetail("ishangke李清01");
        addressEntityExtMapper.add(addressEntityExt);
        int oldcount = addressEntityExtMapper.getCount();
        addressEntityExtMapper.add(addressEntityExt);
        Assert.assertSame(addressEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        AddressEntityExt addressEntityExt = new AddressEntityExt();
        addressEntityExt.setCreateTime(new Date());
        addressEntityExt.setLastModifyTime(new Date());
        addressEntityExt.setEnabled(1);
        addressEntityExt.setDeleted(0);
        addressEntityExt.setCircleId(1);
        addressEntityExt.setLocationId(1);
        addressEntityExt.setPartnerId(1);
        addressEntityExt.setDetail("ishangke李清01");
        addressEntityExtMapper.add(addressEntityExt);
        int oldcount = addressEntityExtMapper.getCount();
        addressEntityExtMapper.deleteById(addressEntityExt.getId());
        Assert.assertSame(addressEntityExtMapper.getCount(), oldcount - 1);
    }

}
