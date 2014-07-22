package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.service.LocationService;
import com.ishangke.edunav.manager.LocationManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class LocationServiceImpl implements LocationService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationManager locationManager;

    @Override
    public List<LocationBo> query(LocationBo locationBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return locationManager.query(locationBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.LOCATION_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.LOCATION_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
