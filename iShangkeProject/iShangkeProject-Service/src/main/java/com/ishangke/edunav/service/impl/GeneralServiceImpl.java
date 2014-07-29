package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.CareerPageViewBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CirclePageViewBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.LocationPageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.commoncontract.model.SchoolPageViewBo;
import com.ishangke.edunav.commoncontract.service.GeneralService;
import com.ishangke.edunav.manager.AuthManager;
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
    @Autowired
    private AuthManager authManager;

    /**********************************************************
     * 
     * Category
     * 
     **********************************************************/
    @Override
    public CategoryPageViewBo queryCategory(CategoryBo categoryBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            List<CategoryBo> data = categoryManager.queryCategory(categoryBo, paginationBo);
            CategoryPageViewBo pageView = new CategoryPageViewBo();
            pageView.setData(data);
            return pageView;
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
    public LocationPageViewBo queryLocation(LocationBo locationBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            List<LocationBo> data = locationManager.query(locationBo, paginationBo);
            LocationPageViewBo pageView = new LocationPageViewBo();
            pageView.setData(data);
            return pageView;

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
    public CirclePageViewBo queryCircle(CircleBo circleBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            List<CircleBo> data = circleManager.queryCircle(circleBo, paginationBo);
            CirclePageViewBo pageView = new CirclePageViewBo();
            pageView.setData(data);
            return pageView;

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
    public SchoolPageViewBo querySchool(SchoolBo schoolBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            List<SchoolBo> data = schoolManager.query(schoolBo, paginationBo);
            SchoolPageViewBo pageView = new SchoolPageViewBo();
            pageView.setData(data);
            return pageView;
           
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
    public CareerPageViewBo queryCareer(CareerBo careerBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            List<CareerBo> data = careerManager.query(careerBo, paginationBo);
            CareerPageViewBo pageView = new CareerPageViewBo();
            pageView.setData(data);
            return pageView;
            
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CAREER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CAREER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
