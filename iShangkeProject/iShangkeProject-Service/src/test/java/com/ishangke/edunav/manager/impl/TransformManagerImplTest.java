package com.ishangke.edunav.manager.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.dataaccess.mapper.ConfigurationEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.TransformManager;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, PermissionManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class TransformManagerImplTest {
    @Autowired
    private ConfigurationEntityExtMapper configurationMapper;
    
    @Autowired
    private TransformManager transformManager;
    
    @Autowired
    private CacheManager cache;

    @Test
    public void testGetAction() throws IllegalArgumentException, IllegalAccessException{
        ConfigurationEntityExt configurationEntityExt = new ConfigurationEntityExt();
        configurationEntityExt.setConfigData("{\"transformRoles\":[{\"name\":\"admin\",\"roleCode\":0,\"entitys\":[{\"name\":\"course\",\"entityCode\":0,\"currentStatuses\":[{\"name\":\"new\",\"statusCode\":0,\"operations\":[{\"name\":\"submit\",\"operateCode\":0,\"url\":\"/submit\"}]}]}]}]}");
        configurationEntityExt.setName("statusTransform");
        configurationMapper.testAdd(configurationEntityExt);
        List<ActionBo> list = transformManager.getActionByGroupName("admin", "course", 0);
        System.out.println(list.size());
        for (Field f : ActionBo.class.getFields()) {
            System.out.println(f.getName() + "===>" + f.get(list.get(0)).toString());
        }
        System.out.println();
        ActionBo a = ((ArrayList<ActionBo>)cache.get("admincourse0")).get(0);
        for (Field f : ActionBo.class.getFields()) {
            System.out.println(f.getName() + "===>" + f.get(a).toString());
        }
        System.out.println("end~");
        ActionBo b = ((ArrayList<ActionBo>)cache.get("admincourse0")).get(0);
        for (Field f : ActionBo.class.getFields()) {
            System.out.println(f.getName() + "===>" + f.get(b).toString());
        }
        System.out.println("end~");
    }
    
}
