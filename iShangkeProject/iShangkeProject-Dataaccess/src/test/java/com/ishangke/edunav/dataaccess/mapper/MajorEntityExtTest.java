package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.MajorEntityExt;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class MajorEntityExtTest {
    @Autowired
    private MajorEntityExtMapper careerEntityExtMapper;

    @Test
    public void testAdd() {
        MajorEntityExt MajorEntityExt = new MajorEntityExt();

        MajorEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        MajorEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        MajorEntityExt.setEnabled(1);
        MajorEntityExt.setDeleted(0);

        careerEntityExtMapper.add(MajorEntityExt);
        int oldcount = careerEntityExtMapper.getCount();
        careerEntityExtMapper.add(MajorEntityExt);
        Assert.assertSame(careerEntityExtMapper.getCount(), oldcount + 1);
    }

    
}
