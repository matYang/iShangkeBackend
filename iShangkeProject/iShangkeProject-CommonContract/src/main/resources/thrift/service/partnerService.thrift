include "model/fault.thrift"
include "model/common.thrift"
include "model/partner.thrift"
include "model/user.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service PartnerService{

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
    common.ResponseBo query(1: partner.PartnerBo partnerBo, 2: common.PaginationBo paginationBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  查询合作商完整信息。<br>
     *  用户可以看到合作商完整信息
     *
     *  @param  id       		合作商Id
     *  @param  UserBo 	  		用户信息
     *
     *  @return 合作商实体 PartnerBo
     *
     */ 
    common.ResponseBo queryById(1: i32 id, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

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
    common.ResponseBo updatePartner(1: partner.PartnerBo partnerBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    common.ResponseBo createPartner(1: partner.PartnerBo partnerBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
}