package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface CoursePromotionManager {
    
    /**
     * 本方法返回课程置顶信息<br>
     * 管理员可以通过此方法调取课程置顶信息
     * 
     * @param coursePromotionBo
     *            课程置顶查询条件
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
    public List<CoursePromotionBo> query(CoursePromotionBo coursePromotionBo, PaginationBo paginationBo);

    /**
     * 本方法创建课程置顶信息<br>
     * 管理员可以通过此方法创建课程置顶信息
     * 
     * @param coursePromotionBo
     *            需要创建的置顶课程对应关系
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
    public CoursePromotionBo createPromotion(CoursePromotionBo coursePromotionBo, UserBo userBo);

    /**
     * 本方法更新课程置顶信息<br>
     * 管理员可以通过此方法更新课程置顶信息
     * 
     * @param coursePromotionBo
     *            需要更新的置顶课程对应关系
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
    public CoursePromotionBo updatePromotion(CoursePromotionBo coursePromotionBo, UserBo userBo);

    /**
     * 本方法删除课程置顶信息<br>
     * 管理员可以通过此方法删除课程置顶信息
     * 
     * @param coursePromotionBo
     *            需要删除的置顶课程对应关系id
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
    public CoursePromotionBo deletePromotion(CoursePromotionBo coursePromotionBo, UserBo userBo);

    public int queryTotal(CoursePromotionBo coursePromotionBo);
    
}
