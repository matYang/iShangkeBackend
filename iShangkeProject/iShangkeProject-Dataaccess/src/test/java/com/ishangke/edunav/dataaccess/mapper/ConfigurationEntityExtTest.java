package com.ishangke.edunav.dataaccess.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ConfigurationEntityExtTest {
    @Autowired
    private ConfigurationEntityExtMapper configurationEntityExttMapper;

    @Test
    public void testGetByName() {
        ConfigurationEntityExt  c =  configurationEntityExttMapper.getByName("statusTransform");
        Assert.assertNotNull(c);
    }
}
