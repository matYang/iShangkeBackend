include "model/fault.thrift"
include "model/common.thrift"
include "model/courseTemplate.thrift"
include "model/location.thrift"
include "model/partner.thrift"
include "model/user.thrift"
include "model/category.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service CourseTemplateService {
    /**
     *  本方法为创建新课程模版<br>
     *  合作商管理员可以通过此方法创建新课程模版
     *
     *  @param  courseTemplateBo    需要被创建的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  UserBo              调用方法的用户的信息
     *
     *  @return 课程模版实体 CourseTemplateBo 
     *
     */
    common.ResponseBo createCourseTemplateBo(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为提交课程模版<br>
     *  合作商管理员可以通过此方法提交课程模版
     *
     *  @param  courseTemplateBo    需要被创建的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  UserBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo submitCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为审核通过课程模版<br>
     *  ishangke管理员可以通过此方法审核通过课程模版
     *
     *  @param  courseTemplateBo          需要被审核的课程模版信息
     *  @param  partnerBo                 合作商信息
     *  @param  commentTemplateApproveBo  审核通过课程模版评论信息
     *  @param  userBo                    调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo approveCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: courseTemplate.CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为审核不通过课程模版<br>
     *  ishangke管理员可以通过此方法审核不通过课程模版
     *
     *  @param  courseTemplateBo          需要被审核的课程模版信息
     *  @param  partnerBo                 合作商信息
     *  @param  commentTemplateApproveBo  审核不通过课程模版评论信息
     *  @param  userBo                    调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo rejectCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: courseTemplate.CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, 3: partner.PartnerBo partnerBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为下架课程模版<br>
     *  合作商管理员可以通过此方法下架课程模版
     *
     *  @param  courseTemplateBo    需要被下架的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo cancelCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

     /**
     *  本方法为重新上架课程模版<br>
     *  合作商管理员可以通过此方法重新上架课程模版
     *
     *  @param  courseTemplateBo    需要被重新上架的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo resubmitCourserTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为删除课程模版<br>
     *  合作商管理员可以通过此方法删除已经下架的课程模版
     *
     *  @param  courseTemplateBo    需要被删除的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo deleteCourseTempalte(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

     /**
     *  本方法为修改课程模版<br>
     *  合作商管理员可以通过此方法修改课程模版
     *
     *  @param  courseTemplateBo    需要被修改的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo updateCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为搜索课程模版<br>
     *  合作商管理员可以通过此方法查询课程模版
     *
     *  @param  courseTemplateBo    需要检索和过滤的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  UserBo              调用方法的用户的信息
     *  @param  paginationBo        分页信息
     *
     *  @return  
     *
     */
    common.ResponseBo queryCourseTempalte(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: user.UserBo userBo, 3: partner.PartnerBo partnerBo, 4: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法返回课程模版详情<br>
     *  合作商/管理员可以通过此方法调取
     *
     *  @param  courseTemplateBo            课程模板id
     *  @param  userBo                      调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo queryCourseTempalteById(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)


}

