package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CircleEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;
import com.ishangke.edunav.manager.CircleManager;
import com.ishangke.edunav.manager.converter.CircleConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CircleManagerImpl implements CircleManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CircleManagerImpl.class);

    @Autowired
    private CircleEntityExtMapper circleEntityExtMapper;

    @Override
    public List<CircleBo> queryCircle(CircleBo circleBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (circleBo == null) {
            throw new ManagerException("Circle Query Failed: CircleBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CircleEntityExt circleEntity = CircleConverter.fromBo(circleBo);
        List<CircleEntityExt> circleList = null;
        List<CircleBo> resultList = null;

        try {
            circleList = circleEntityExtMapper.list(circleEntity, pageEntity);
            for (CircleEntityExt circlePo : circleList) {
                resultList.add(CircleConverter.toBo(circlePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Circle Query Failed", t);
        }
    }

}
