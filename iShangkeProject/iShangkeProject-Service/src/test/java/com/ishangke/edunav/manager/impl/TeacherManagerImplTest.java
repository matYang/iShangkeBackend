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
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.exception.ManagerException;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, TeacherManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class TeacherManagerImplTest extends BaseTest {

    @Autowired
    private TeacherManager teacherManager;

    @Test
    (expected = ManagerException.class)
    public void testListAddTeacher() {
        UserBo userBo = new UserBo();
        userBo.setId(0);
        TeacherBo teacherBo = new TeacherBo();
        teacherManager.createTeacher(teacherBo, userBo);
    }
}
