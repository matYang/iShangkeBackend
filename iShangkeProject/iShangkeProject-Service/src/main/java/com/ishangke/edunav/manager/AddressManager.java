package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface AddressManager {
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
    AddressBo createAddress(AddressBo addressBo, UserBo userBo);

	/**
	 *  更新校区信息。<br>
	 *  管理员与合作商可以更新校区信息
	 *
	 *  @param  addressBo          需要更新的校区信息
	 *  @param  userBo             发起更新的管理员/合作商信息   $
	 *
	 *  @return 更新完成的校区信息
	 *
	 */
    AddressBo updateAddress(AddressBo addressBo, UserBo userBo);

	/**
	 *  删除校区信息。<br>
	 *  管理员与合作商可以删除校区信息
	 *
	 *  @param  addressBo          需要删除的校区信息
	 *  @param  userBo             发起删除的管理员/合作商信息   $
	 *
	 *  @return 
	 *
	 */
    AddressBo deleteAddress(AddressBo addressBo, UserBo userBo);

	/**
	 *  查询校区信息。<br>
	 *  管理员与合作商可以查询校区信息
	 *
	 *  @param  addressBo          需要查询的校区信息
	 *  @param  userBo             发起查询的用户信息   $
	 *  @param  paginationBo       分页信息
	 *
	 *  @return  Address 列表
	 *
	 */
    List<AddressBo> query(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo);
    
    int queryTotal(AddressBo addressBo, UserBo userBo);
}
