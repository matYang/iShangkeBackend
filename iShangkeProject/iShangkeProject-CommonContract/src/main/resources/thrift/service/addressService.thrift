include "model/fault.thrift"
include "model/common.thrift"
include "model/address.thrift"
include "model/user.thrift"
include "model/partner.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service AddressService{

	/**
     *  创建校区信息。<br>
     *  管理员与合作商可以创建校区信息
     *
     *  @param  addressBo          需要创建的校区信息
     *  @param  userBo             发起创建的管理员/合作商信息
     *	@param 	partnerBo 		   合作商信息
     *
     *  @return 创建完成的校区信息
     *
     */
    address.AddressBo createAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: partner.PartnerBo partnerBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新校区信息。<br>
     *  管理员与合作商可以更新校区信息
     *
     *  @param  addressBo          需要更新的校区信息
     *  @param  userBo             发起更新的管理员/合作商信息
     *	@param 	partnerBo 		   合作商信息
     *
     *  @return 更新完成的校区信息
     *
     */
    address.AddressBo updateAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: partner.PartnerBo partnerBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除校区信息。<br>
     *  管理员与合作商可以删除校区信息
     *
     *  @param  addressBo          需要删除的校区信息
     *  @param  userBo             发起删除的管理员/合作商信息
     *	@param 	partnerBo 		   合作商信息
     *
     *  @return 
     *
     */
    address.AddressBo deleteAddress(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: partner.PartnerBo partnerBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    list<address.AddressBo> query(1: address.AddressBo addressBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

	

}