package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.LocationEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;
import com.ishangke.edunav.manager.LocationManager;
import com.ishangke.edunav.manager.converter.LocationConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class LocationManagerImpl implements LocationManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationManagerImpl.class);

    @Autowired
    private LocationEntityExtMapper locationMapper;

    @Override
    public List<LocationBo> query(LocationBo locationBo, PaginationBo paginationBo) {
        LocationEntityExt locationEntity = locationBo == null ? null : LocationConverter.fromBo(locationBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<LocationEntityExt> results = null;
        try {
            results = locationMapper.list(locationEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Location query failed", t);
        }

        if (results == null) {
            return new ArrayList<LocationBo>();
        }
        List<LocationBo> convertedResults = new ArrayList<LocationBo>();
        for (LocationEntityExt result : results) {
            convertedResults.add(LocationConverter.toBo(result));
        }
        return convertedResults;
    }

}
