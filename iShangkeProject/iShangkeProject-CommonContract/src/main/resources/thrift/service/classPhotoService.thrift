include "model/fault.thrift"
include "model/classPhoto.thrift"
include "model/user.thrift"
include "model/partner.thrift"
include "model/common.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service ClassPhotoService{
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
    classPhoto.ClassPhotoBo createClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    classPhoto.ClassPhotoBo updateClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    classPhoto.ClassPhotoBo deleteClassPhoto(1: classPhoto.ClassPhotoBo classPhotoBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    list<classPhoto.ClassPhotoBo> query(1: classPhoto.ClassPhotoBo classPhotoBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}