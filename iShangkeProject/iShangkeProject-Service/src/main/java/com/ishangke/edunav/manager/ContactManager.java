package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface ContactManager {

	/**
     *  创建常用联系人信息。<br>
     *  用户可以创建常用联系人信息
     *
     *  @param  contactBo          需要创建的常用联系人信息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的常用联系人信息
     *
     */
    ContactBo createContact(ContactBo contactBo, UserBo userBo);
    
    /**
     *  更新常用联系人信息。<br>
     *  用户可以更新常用联系人信息
     *
     *  @param  contactBo          需要更新的常用联系人信息
     *  @param  userBo             发起更新的用户信息
     *
     *  @return 更新完成的常用联系人信息
     *
     */
    ContactBo updateContact(ContactBo contactBo, UserBo userBo);

    /**
     *  删除常用联系人信息。<br>
     *  用户可以删除常用联系人信息
     *
     *  @param  contactBo          需要删除的常用联系人信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 
     *
     */
    ContactBo deleteContact(ContactBo contactBo, UserBo userBo);
    
    /**
     *  查询常用联系人信息。<br>
     *  用户可以查询常用联系人信息
     *
     *  @param  contactBo          需要查询的常用联系人信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  Contact 列表
     *
     */
    List<ContactBo> query(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo);
    int queryTotal(ContactBo contactBo, UserBo userBo);
}
