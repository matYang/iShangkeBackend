package com.ishangke.edunav.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

@Component
public interface PurposeCourseManager {
    
    /**
     * 本方法返回意向课程信息
     * 管理员可以通过此方法调取意向课程信息
     * 
     * @param purposeCourseBo 意向课程查询条件
     * @param userBo          调用方法的用户信息
     * @param paginationBo
     * @return
     */
    public List<PurposeCourseBo> query(PurposeCourseBo purposeCourseBo,UserBo userBo,PaginationBo paginationBo);
    
    /**
     *  本方法创建意向课程信息
     * 管理员可以通过此方法创建意向课程信息 
     * 
     * @param purposeCourseBo  创建意向课程的信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public PurposeCourseBo createPurpose(PurposeCourseBo purposeCourseBo,UserBo userBo);
    
    /**
     *  本方法更新意向课程信息
     * 管理员可以通过此方法更新意向课程信息 
     * 
     * @param purposeCourseBo  更新意向课程的信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public PurposeCourseBo updatePurpose(PurposeCourseBo purposeCourseBo,UserBo userBo);
    
    /**
     *  本方法删除意向课程信息
     * 管理员可以通过此方法删除意向课程信息 
     * 
     * @param purposeCourseBo  删除意向课程的ID信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public PurposeCourseBo deletePurpose(PurposeCourseBo purposeCourseBo,UserBo userBo);
    
    /**
     *  本方法查询意向课程信息数量
     * 管理员可以通过此方法查询意向课程信息数量 
     * 
     * @param purposeCourseBo  查询意向课程数量的条件信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    public int queryTotal(PurposeCourseBo purposeCourseBo,UserBo userBo);
    
    /**
     * 本方法返回指定ID意向课程信息
     * 管理员可以通过此方法查询指定ID意向课程信息
     * 
     * @param id       意向课程对应ID
     * @param userBo   调用方法的用户信息
     * @return
     */
    public PurposeCourseBo queryPurposeById(int id,UserBo userBo);
}
