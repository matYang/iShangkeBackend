package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface PartnerManager {

    /**
     * 查询合作商信息。<br>
     * 用户可以看到合作商相关信息
     * 
     * @param partnerBo
     *            需要检索的合作商信息
     * @param paginationBo
     *            分页信息
     * @param userBo
     *            用户信息
     * 
     * @return 合作商实体 PartnerBo 列表
     * 
     * 
     * @param partnerBo
     * @param paginationBo
     * @param userBo
     */
    public List<PartnerBo> query(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo);

    /**
     * 查询合作商完整信息。<br>
     * 用户可以看到合作商完整信息
     * 
     * @param partnerBo
     *            合作商Id
     * @param UserBo
     *            用户信息
     * 
     * @return 合作商实体 PartnerBo
     * 
     * 
     * @param partnerBo
     * @param userBo
     */
    public PartnerBo queryById(PartnerBo partnerBo, UserBo userBo);

    /**
     * 更新合作商信息。<br>
     * 管理员可以更新合作商的信息
     * 
     * @param partnerBo
     *            需要更新的合作商信息
     * @param userBo
     *            调用方法的管理员信息
     * 
     * @return 更新过后的合作商信息
     * 
     * 
     * @param partnerBo
     * @param userBo
     */
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo);

    /**
     * 创建合作商信息。<br>
     * 管理员可以录入新合作商的信息
     * 
     * @param partnerBo
     *            需要创建的新合作商信息
     * @param userBo
     *            调用方法的管理员信息
     * 
     * @return 创建完毕的合作商信息
     * 
     * 
     * @param partnerBo
     * @param userBo
     */
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo);

}
