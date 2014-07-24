package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.commoncontract.service.GeneralService;
import com.ishangke.edunav.manager.CareerManager;
import com.ishangke.edunav.manager.CategoryManager;
import com.ishangke.edunav.manager.CircleManager;
import com.ishangke.edunav.manager.LocationManager;
import com.ishangke.edunav.manager.SchoolManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class GeneralServiceImpl implements GeneralService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralServiceImpl.class);

    @Autowired
    private CategoryManager categoryManager;
    @Autowired
    private LocationManager locationManager;
    @Autowired
    private CircleManager circleManager;
    @Autowired
    private SchoolManager schoolManager;
    @Autowired
    private CareerManager careerManager;

    /**********************************************************
     *
     * Category
     *
     **********************************************************/
    @Override
    public List<CategoryBo> queryCategory(CategoryBo categoryBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return categoryManager.queryCategory(categoryBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CATEGORY_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CATEGORY_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     *
     * Location
     *
     **********************************************************/
    @Override
    public List<LocationBo> queryLocation(LocationBo locationBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
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

    /**********************************************************
     *
     * Circle
     *
     **********************************************************/
    @Override
    public List<CircleBo> queryCircle(CircleBo circleBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return circleManager.queryCircle(circleBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CIRCLE_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CIRCLE_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     *
     * School
     *
     **********************************************************/
    @Override
    public List<SchoolBo> querySchool(SchoolBo schoolBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return schoolManager.query(schoolBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SCHOOL_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.SCHOOL_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     *
     * Career
     *
     **********************************************************/
    @Override
    public List<CareerBo> queryCareer(CareerBo careerBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return careerManager.query(careerBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CAREER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CAREER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
