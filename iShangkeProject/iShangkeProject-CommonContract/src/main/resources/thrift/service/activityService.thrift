include "model/fault.thrift"
include "model/activity.thrift"
include "model/user.thrift"
include "model/partner.thrift"
include "model/common.thrift"
include "model/course.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service ActivityService{
	
	/**
     *  创建活动信息。<br>
     *  管理员与合作商可以创建活动信息
     *
     *  @param  activityBo         需要创建的活动信息
     *  @param  courseBo         活动相关的课程信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的活动信息
     *
     */
    common.ResponseBo createActivity(1: activity.ActivityBo activityBo, 2: course.CourseBo courseBo, 3: partner.PartnerBo partnerBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  提交活动信息审核。<br>
     *  合作商可以提交活动信息审核
     *
     *  @param  activityBo         需要提交的活动信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  userBo             发起提交的用户信息
     *
     *  @return 提交完成的活动信息
     *
     */
    common.ResponseBo submitActivity(1: activity.ActivityBo activityBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  认可活动信息。<br>
     *  管理员可以审核认可活动信息
     *
     *  @param  activityBo         需要认可的活动信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  commentActivityApproveBo     与认可相关的评论
     *  @param  userBo             发起认可的管理员信息
     *
     *  @return 认可完成的活动信息
     *
     */
    common.ResponseBo approveActivity(1: activity.ActivityBo activityBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  拒绝活动信息。<br>
     *  管理员可以审核拒绝活动信息
     *
     *  @param  activityBo         需要拒绝的活动信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  commentActivityRejectBo     与拒绝相关的评论
     *  @param  userBo             发起拒绝的管理员信息
     *
     *  @return 拒绝完成的活动信息
     *
     */
    common.ResponseBo rejectActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  取消活动信息。<br>
     *  合作商可以取消活动信息
     *
     *  @param  activityBo         需要取消的活动信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  userBo             发起取消的用户信息
     *
     *  @return 取消完成的活动信息
     *
     */
    common.ResponseBo cancelActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  删除活动信息。<br>
     *  管理员与合作商可以删除活动信息
     *
     *  @param  activityBo         需要删除的活动信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 删除完成的活动信息
     *
     */
    common.ResponseBo deleteActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询活动信息。<br>
     *  用户可以查询活动信息
     *
     *  @param  activityBo         需要查询的活动信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return 推广信息实体 Activity 列表
     *
     */
    common.ResponseBo query(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}