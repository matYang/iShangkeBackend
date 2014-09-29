package com.ishangke.edunav.manager;

import java.util.List;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface GroupBuyPhotoManager {
    
    /**
     * 本方法返回团购图片信息
     * 管理员可以通过此方法调取团购图片信息
     * 
     * @param groupBuyPhotoBo 团购图片查询条件
     * @param userBo          调用方法的用户信息
     * @param paginationBo
     * @return
     */
    public List<GroupBuyPhotoBo> query(GroupBuyPhotoBo groupBuyPhotoBo,UserBo userBo,PaginationBo paginationBo);
    
    /**
     *  本方法创建团购图片信息
     * 管理员可以通过此方法创建团购图片信息 
     * 
     * @param groupBuyPhotoBo  创建团购图片的信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public GroupBuyPhotoBo createGroupBuyPhoto(GroupBuyPhotoBo groupBuyPhotoBo,UserBo userBo);
    
    /**
     *  本方法更新团购图片信息
     * 管理员可以通过此方法更新团购图片信息 
     * 
     * @param groupBuyPhotoBo  更新团购图片的信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public GroupBuyPhotoBo updateGroupBuyPhoto(GroupBuyPhotoBo groupBuyPhotoBo,UserBo userBo);
    
    /**
     *  本方法删除团购图片信息
     * 管理员可以通过此方法删除团购图片信息 
     * 
     * @param groupBuyPhotoBo  删除团购图片的ID信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public GroupBuyPhotoBo deleteGroupBuyPhoto(GroupBuyPhotoBo groupBuyPhotoBo,UserBo userBo);
    
    /**
     *  本方法查询团购图片信息数量
     * 管理员可以通过此方法查询团购图片信息数量 
     * 
     * @param groupBuyPhotoBo  查询团购图片数量的条件信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public int queryTotal(GroupBuyPhotoBo groupBuyPhotoBo,UserBo userBo);
}
