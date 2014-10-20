include "model/fault.thrift"
include "model/common.thrift"
include "model/partner.thrift"
include "model/user.thrift"
include "model/address.thrift"
include "model/classPhoto.thrift"
include "model/teacher.thrift"
include "model/activity.thrift"
include "model/course.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service PartnerService{

    /**********************************************************
    *
    *   关于合作商的 PartnerService
    *
    **********************************************************/

	/**
     *  查询合作商信息。<br>
     *  用户可以看到合作商相关信息
     *
     *  @param  partnerBo       需要检索的合作商信息
     *  @param  paginationBo    分页信息
     *  @param  userBo    		用户信息
     *
     *  @return 合作商实体 PartnerBo 列表
     *
     */ 
    partner.PartnerPageViewBo  queryPartner(1: partner.PartnerBo partnerBo, 2: common.PaginationBo paginationBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    partner.PartnerPageViewBo  queryPartnerByFilter(1: partner.PartnerBo partnerBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  查询合作商完整信息。<br>
     *  用户可以看到合作商完整信息
     *
     *  @param  partnerBo       合作商Id
     *  @param  UserBo 	  		用户信息
     *
     *  @return 合作商实体 PartnerBo
     *
     */ 
    partner.PartnerBo  queryPartnerById(1: partner.PartnerBo partnerBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  更新合作商信息。<br>
     *  管理员可以更新合作商的信息
     *
     *  @param  partnerBo       需要更新的合作商信息
     *  @param  userBo          调用方法的管理员信息
     *
     *  @return 更新过后的合作商信息
     *
     */ 
    partner.PartnerBo  updatePartner(1: partner.PartnerBo partnerBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  创建合作商信息。<br>
     *  管理员可以录入新合作商的信息
     *
     *  @param  partnerBo       需要创建的新合作商信息
     *  @param  userBo          调用方法的管理员信息
     *
     *  @return 创建完毕的合作商信息
     *
     */ 
    partner.PartnerBo  createPartner(1: partner.PartnerBo partnerBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)






    
    /**********************************************************
    *
    *   关于地址的 Address
    *
    **********************************************************/

    /**
     *  创建校区信息。<br>
     *  管理员与合作商可以创建校区信息
     *
     *  @param  addressBo          需要创建的校区信息
     *  @param  userBo             发起创建的管理员/合作商信息
     *
     *  @return 创建完成的校区信息
     *
     */
    address.AddressBo createAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新校区信息。<br>
     *  管理员与合作商可以更新校区信息
     *
     *  @param  addressBo          需要更新的校区信息
     *  @param  userBo             发起更新的管理员/合作商信息
     *
     *  @return 更新完成的校区信息
     *
     */
    address.AddressBo updateAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除校区信息。<br>
     *  管理员与合作商可以删除校区信息
     *
     *  @param  addressBo          需要删除的校区信息
     *  @param  userBo             发起删除的管理员/合作商信息
     *
     *  @return 
     *
     */
    address.AddressBo deleteAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询校区信息。<br>
     *  管理员与合作商可以查询校区信息
     *
     *  @param  addressBo          需要查询的校区信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  Address 列表
     *
     */
    address.AddressPageViewBo queryAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)








    /**********************************************************
    *
    *   关于机构照片的 ClassPhoto
    *
    **********************************************************/
    
    /**
     *  创建教师信息。<br>
     *  管理员与合作商可以创建教师信息
     *
     *  @param  classPhotoBo          需要创建的教师信息
     *  @param  userBo             发起创建的管理员/合作商信息
     *
     *  @return 创建完成的教师信息
     *
     */
    classPhoto.ClassPhotoBo createClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新教师信息。<br>
     *  管理员与合作商可以更新教师信息
     *
     *  @param  classPhotoBo          需要更新的教师信息
     *  @param  userBo             发起更新的管理员/合作商信息
     *
     *  @return 更新完成的教师信息
     *
     */
    classPhoto.ClassPhotoBo updateClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除教师信息。<br>
     *  管理员与合作商可以删除教师信息
     *
     *  @param  classPhotoBo          需要删除的教师信息
     *  @param  userBo             发起删除的管理员/合作商信息
     *
     *  @return 删除完成的教师信息
     *
     */
    classPhoto.ClassPhotoBo deleteClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询教师信息。<br>
     *  管理员与合作商可以查询教师信息
     *
     *  @param  classPhotoBo          需要查询的教师信息
     *  @param  partnerBo          教师相关的合作商信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return 推广信息实体 ClassPhoto 列表
     *
     */
    classPhoto.ClassPhotoPageViewBo queryClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)








    /**********************************************************
    *
    *   关于教师照片的 TeacherPhoto
    *
    **********************************************************/

    /**
     *  创建教师信息。<br>
     *  管理员与合作商可以创建教师信息
     *
     *  @param  teacherBo          需要创建的教师信息
     *  @param  userBo             发起创建的管理员/合作商信息
     *
     *  @return 创建完成的教师信息
     *
     */
    teacher.TeacherBo createTeacher(1: teacher.TeacherBo teacherBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新教师信息。<br>
     *  管理员与合作商可以更新教师信息
     *
     *  @param  teacherBo          需要更新的教师信息
     *  @param  userBo             发起更新的管理员/合作商信息
     *
     *  @return 更新完成的教师信息
     *
     */
    teacher.TeacherBo updateTeacher(1: teacher.TeacherBo teacherBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除教师信息。<br>
     *  管理员与合作商可以删除教师信息
     *
     *  @param  teacherBo          需要删除的教师信息
     *  @param  userBo             发起删除的管理员/合作商信息
     *
     *  @return 删除完成的教师信息
     *
     */
    teacher.TeacherBo deleteTeacher(1: teacher.TeacherBo teacherBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询教师信息。<br>
     *  管理员与合作商可以查询教师信息
     *
     *  @param  teacherBo          需要查询的教师信息
     *  @param  partnerBo          教师相关的合作商信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return 推广信息实体 Teacher 列表
     *
     */
    teacher.TeacherPageViewBo queryTeacher(1: teacher.TeacherBo teacherBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)








    /**********************************************************
    *
    *   关于活动的 Activity
    *
    **********************************************************/

    /**
     *  创建活动信息。<br>
     *  管理员与合作商可以创建活动信息
     *
     *  @param  activityBo         需要创建的活动信息
     *  @param  courseBo           活动相关的课程信息
     *  @param  partnerBo          活动相关的合作商信息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的活动信息
     *
     */
    activity.ActivityBo createActivity(1: activity.ActivityBo activityBo, 2: course.CourseBo courseBo, 3: partner.PartnerBo partnerBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    activity.ActivityBo submitActivity(1: activity.ActivityBo activityBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    activity.ActivityBo approveActivity(1: activity.ActivityBo activityBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    activity.ActivityBo rejectActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    activity.ActivityBo cancelActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    activity.ActivityBo deleteActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    activity.ActivityPageViewBo queryActivity(1: activity.ActivityBo activityBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}