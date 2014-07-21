package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ConfigurationEntityExtTest {
    @Autowired
    private ConfigurationEntityExtMapper configurationEntityExttMapper;

    @Test
    public void testGetByName() {
        ConfigurationEntityExt  c =  configurationEntityExttMapper.getByName("_test_name_1_爱上课");
      
        Assert.assertEquals("_test_CD_1_爱上课", c.getConfigData());

    }

    @Test
    public void testListAll() {
        List<ConfigurationEntityExt> result = configurationEntityExttMapper.listAll();
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_CD_1_爱上课", result.get(0).getConfigData());
        Assert.assertEquals("_test_CD_2_爱上课", result.get(1).getConfigData());
        Assert.assertEquals("_test_CD_3_爱上课", result.get(2).getConfigData());
        Assert.assertEquals("_test_CD_4_爱上课", result.get(3).getConfigData());
    }
}
