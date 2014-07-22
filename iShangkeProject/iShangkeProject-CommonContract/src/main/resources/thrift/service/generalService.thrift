include "model/fault.thrift"
include "model/common.thrift"
include "model/configuration.thrift"
include "model/circle.thrift"
include "model/category.thrift"
include "model/location.thrift"
include "model/school.thrift"
include "model/career.thrift"


namespace java com.ishangke.edunav.commoncontract.service

service GeneralService{

    /**********************************************************
    *
    *   Configuration
    *
    **********************************************************/
    string getConfigurationByName(1: string name) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    list<configuration.ConfigurationBo> listAllConfiguration() throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   Category
    *
    **********************************************************/
    list<category.CategoryBo> queryCategory(1: category.CategoryBo categoryBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   Location
    *
    **********************************************************/
    list<location.LocationBo> queryLocation(1: location.LocationBo locationBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   Circle
    *
    **********************************************************/
    list<circle.CircleBo> queryCircle(1: circle.CircleBo circleBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   School
    *
    **********************************************************/
    list<school.SchoolBo> querySchool(1: school.SchoolBo schoolBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   Career
    *
    **********************************************************/
    list<career.CareerBo> queryCareer(1: career.CareerBo careerBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}