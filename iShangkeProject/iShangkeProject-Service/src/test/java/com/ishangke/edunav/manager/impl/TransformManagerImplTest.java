package com.ishangke.edunav.manager.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;

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
import com.ishangke.edunav.manager.transform.Operation;

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
        ArrayList<ActionBo> list = (ArrayList<ActionBo>) transformManager.getActionByRoleName("user", "course", 100);
        System.out.println("count: " + list.size());
        for (ActionBo a : list) {
            for (Field f : ActionBo.class.getFields()) {
                System.out.println(f.getName() + "===>" + f.get(a).toString());
            }
            System.out.println("========");
        }
        System.out.println();
        ArrayList<ActionBo> a = (ArrayList<ActionBo>)cache.get("transformactionusercourse100");
        System.out.println("end~");
    }
    
    @Test
    public void testGetOperation() throws IllegalArgumentException, IllegalAccessException {
        cache.del("transformoperationpartneradminbooking4");
        ArrayList<Operation> list = (ArrayList<Operation>) transformManager.getOperationByRoleName("partneradmin", "booking", 4);
        System.out.println("count: " + list.size());
        for (Operation a : list) {
            for (Field f : Operation.class.getDeclaredFields()) {
                f.setAccessible(true);
                System.out.println(f.getName() + "===>" + f.get(a).toString());
            }
            System.out.println("========");
        }
        System.out.println();
        ArrayList<Operation> qqq = (ArrayList<Operation>)cache.get("transformoperationpartneradminbooking4");
        
        for (Operation a : qqq) {
            for (Field f : Operation.class.getDeclaredFields()) {
                f.setAccessible(true);
                System.out.println(f.getName() + "===>" + f.get(a).toString());
            }
            System.out.println("========");
        }
        System.out.println("end~");
    }
}
