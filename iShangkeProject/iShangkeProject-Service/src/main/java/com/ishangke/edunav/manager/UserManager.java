package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface UserManager {
    

    /**
     * 本方法为销毁用户session信息的功能<br>
     * 
     * @param sessionBo
     *            需要被销毁session的用户信息
     * @return
     */
    void disposeSession(SessionBo sessionBo);

    /**
     * 本方法为普通用户提供自动识别的功能。<br>
     * API端读取用户前端存储的session string，调用该方法自动获得当前用户信息
     * 
     * @param sessionBo
     * @return 用户实体 UserBo
     * 
     */
    UserBo authenticate(SessionBo sessionBo);

    /**
     * 本方法为普通用户提供注册的功能。<br>
     * 用户可以通过此方法进行注册。
     * 
     * @param userBo
     *            用户注册信息
     * @return 用户实体 UserBo
     * 
     * @param userBo
     */
    UserBo registerUser(UserBo userBo, SessionBo sessionBo);

    /**
     * 本方法为普通用户提供手机验证。<br>
     * 用户可以通过此方法向用户发送验证短信。
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    SessionBo openCellSession(UserBo userBo);


    /**
     * 本方法为普通用户提供忘记密码时手机验证。<br>
     * 用户可以通过此方法向用户发送验证短信。
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    SessionBo openForgetPasswordSession(UserBo userBo);
    
    
    SessionBo recoverPassword(PasswordBo passwordBo);
    
    
    SessionBo changePassword(PasswordBo passwordBo);



    /**
     * 本方法为所有用户提供用户使用手机号码登录的功能。<br>
     * 所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     * 
     * @param loginBo
     *            用户登录信息
     * 
     * @return SessionBo
     * 
     * 
     * @param loginBo
     */
    SessionBo loginByUser(LoginBo loginBo);

    /**
     * 本方法为所有用户提供使用识别码登录的功能。<br>
     * 所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     * 
     * @param loginBo
     *            用户登录信息
     * 
     * @return SessionBo
     * 
     * 
     * @param loginBo
     */
    SessionBo loginByReference(LoginBo loginBo);

    /**
     * 本方法为ishangke管理员创建新用户<br>
     * ishangke管理员可以创建合作商管理员，普通用户
     * 
     * @param targetUser
     *            需要被创建的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param targetUser
     * @param currentUser
     */
    UserBo createUser(UserBo targetUser,  UserBo currentUser);
    
    UserBo createPartnerUser(UserBo targetUser, PartnerBo partner, UserBo currentUser);

    /**
     * 本方法为ishangke管理员删除用户<br>
     * ishangke管理员可以删除合作商管理员，普通用户
     * 
     * @param targetUser
     *            需要被删除的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 删除结果
     * 
     * 
     * @param targetUser
     * @param currentUser
     */
    UserBo deleteUser(UserBo targetUser, UserBo currentUser);

    /**
     * 本方法为修改用户信息的功能<br>
     * ishangke管理员可以修改合作商管理员，普通用户的信息。任意用户可以修改自身的用户信息
     * 
     * @param targetUser
     *            需要被修改的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param targetUser
     * @param currentUser
     */
    UserBo updateUser(UserBo targetUser, UserBo currentUser);

    /**
     * 本方法为查看用户信息的功能<br>
     * ishangke管理员可以查看合作商管理员，普通用户的信息。任意用户可以查看自身的用户信息
     * 
     * @param queryUser
     *            需要被查询的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param queryUser
     * @param currentUser
     */
    UserBo queryUserInfo(UserBo queryUser, UserBo currentUser);

    /**
     * 本方法为查询用户信息的功能<br>
     * ishangke管理员可以按条件搜索合作商管理员、普通用户的信息。
     * 
     * @param queryUser
     *            需要检索和过滤的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 用户实体 UserBo 列表
     * 
     * 
     * @param queryUser
     * @param currentUser
     * @param pagnationBo
     */
    List<UserBo> queryUser(UserBo queryUser, UserBo currentUser, PaginationBo pagnationBo);

    int getPartnerIdByUserId(int userId);


}
