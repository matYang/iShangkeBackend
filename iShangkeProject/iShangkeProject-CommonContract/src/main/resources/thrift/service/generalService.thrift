include "model/fault.thrift"
include "model/common.thrift"
include "model/circle.thrift"
include "model/category.thrift"
include "model/location.thrift"
include "model/school.thrift"
include "model/major.thrift"
include "model/career.thrift"


namespace java com.ishangke.edunav.commoncontract.service

service GeneralService{



    /**********************************************************
    *
    *   Category
    *
    **********************************************************/
    category.CategoryPageViewBo queryCategory(1: category.CategoryBo categoryBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   Location
    *
    **********************************************************/
    location.LocationPageViewBo queryLocation(1: location.LocationBo locationBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   Circle
    *
    **********************************************************/
    circle.CirclePageViewBo queryCircle(1: circle.CircleBo circleBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   School
    *
    **********************************************************/
    school.SchoolPageViewBo querySchool(1: school.SchoolBo schoolBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)



    /**********************************************************
    *
    *   Major
    *
    **********************************************************/
    major.MajorPageViewBo queryMajor(1: major.MajorBo majorBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)



    /**********************************************************
    *
    *   Career
    *
    **********************************************************/
    career.CareerPageViewBo queryCareer(1: career.CareerBo careerBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}