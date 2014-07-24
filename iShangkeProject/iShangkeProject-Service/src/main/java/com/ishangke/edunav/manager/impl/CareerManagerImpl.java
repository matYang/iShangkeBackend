package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CareerEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CareerEntityExt;
import com.ishangke.edunav.manager.CareerManager;
import com.ishangke.edunav.manager.converter.CareerConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CareerManagerImpl implements CareerManager {

    @Autowired
    private CareerEntityExtMapper careerMapper;

    @Override
    public List<CareerBo> query(CareerBo careerBo, PaginationBo paginationBo) {
        CareerEntityExt careerEntity = careerBo == null ? null : CareerConverter.fromBo(careerBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<CareerEntityExt> results = null;
        try {
            results = careerMapper.list(careerEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Career query failed", t);
        }

        if (results == null) {
            return new ArrayList<CareerBo>();
        }
        List<CareerBo> convertedResults = new ArrayList<CareerBo>();
        for (CareerEntityExt result : results) {
            convertedResults.add(CareerConverter.toBo(result));
        }
        return convertedResults;
    }

}
