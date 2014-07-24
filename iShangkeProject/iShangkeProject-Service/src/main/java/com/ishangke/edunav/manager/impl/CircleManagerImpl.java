package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private CircleEntityExtMapper circleMapper;

    @Override
    public List<CircleBo> queryCircle(CircleBo circleBo, PaginationBo paginationBo) {
        CircleEntityExt circleEntity = circleBo == null ? null : CircleConverter.fromBo(circleBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<CircleEntityExt> results = null;
        try {
            results = circleMapper.list(circleEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Circle query failed", t);
        }

        if (results == null) {
            return new ArrayList<CircleBo>();
        }
        List<CircleBo> convertedResults = new ArrayList<CircleBo>();
        for (CircleEntityExt result : results) {
            convertedResults.add(CircleConverter.toBo(result));
        }
        return convertedResults;
    }

}
