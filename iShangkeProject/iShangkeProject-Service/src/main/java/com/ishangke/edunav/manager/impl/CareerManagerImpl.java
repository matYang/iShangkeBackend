package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(CareerManagerImpl.class);

    @Autowired
    private CareerEntityExtMapper careerMapper;

    @Override
    public List<CareerBo> query(CareerBo careerBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (careerBo == null) {
            throw new ManagerException("Career Query Failed: CareerBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CareerEntityExt careerEntity = CareerConverter.fromBo(careerBo);
        List<CareerEntityExt> careerList = null;
        List<CareerBo> resultList = null;

        try {
            careerList = careerMapper.list(careerEntity, pageEntity);
            for (CareerEntityExt careerPo : careerList) {
                resultList.add(CareerConverter.toBo(careerPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Career Query Failed", t);
        }
    }

}
