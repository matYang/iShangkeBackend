package com.ishangke.edunav.manager.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.PermissionManager;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, PermissionManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class PermissionManagerImplTest extends BaseTest {

    @Autowired
    private PermissionManager permissionManager;

    @Test
    public void testListPermissionsByUser() {
        UserBo userBo = new UserBo();
        userBo.setId(1);
        permissionManager.listPermissionsByUser(userBo);
    }
}
