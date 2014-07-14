package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, SpreadEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class SpreadEntityExtTest extends BaseTest {
    @Autowired
    private SpreadEntityExtMapper spreadEntityExtMapper;

    //resource里面
    public SpreadEntityExtTest() {
        scriptAfterClass = "SpreadEntityExtTestAfter.sql";
        scriptBeforeClass = "SpreadEntityExtTestBefore.sql";
    }

    @Test
    public void testAdd() {
        SpreadEntityExt spreadEntityExt = new SpreadEntityExt();
        spreadEntityExt.setCreateTime(new Date());
       
        spreadEntityExt.setLastModifyTime(new Date());
        spreadEntityExt.setDeleted(0);
        spreadEntityExt.setEnabled(1);
       
        int oldcount = spreadEntityExtMapper.getCount();
        spreadEntityExtMapper.add(spreadEntityExt);
        Assert.assertSame(spreadEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        SpreadEntityExt spreadEntityExt = new SpreadEntityExt();
        spreadEntityExt.setCreateTime(new Date());
        
        spreadEntityExt.setLastModifyTime(new Date());
        spreadEntityExt.setDeleted(0);
        spreadEntityExt.setEnabled(1);
        
        spreadEntityExtMapper.add(spreadEntityExt);
        int oldcount = spreadEntityExtMapper.getCount();
        spreadEntityExtMapper.deleteById(spreadEntityExt.getId());
        Assert.assertSame(spreadEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        SpreadEntityExt SpreadQueryEntity = new SpreadEntityExt();
        SpreadQueryEntity.setUrl("_test_");
        List<SpreadEntityExt> result = spreadEntityExtMapper.list(SpreadQueryEntity, page);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("_test_url_2_", result.get(0).getUrl());
    }
}
