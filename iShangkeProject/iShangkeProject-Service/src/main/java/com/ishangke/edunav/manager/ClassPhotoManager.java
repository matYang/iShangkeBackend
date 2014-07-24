package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface ClassPhotoManager {

    /**
     * 创建教师信息。<br>
     * 管理员与合作商可以创建教师信息
     * 
     * @param classPhotoBo
     *            需要创建的教师信息
     * @param userBo
     *            发起创建的管理员/合作商信息
     * 
     * @return 创建完成的教师信息
     * 
     */
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo);

    /**
     * 更新教师信息。<br>
     * 管理员与合作商可以更新教师信息
     * 
     * @param classPhotoBo
     *            需要更新的教师信息
     * @param userBo
     *            发起更新的管理员/合作商信息
     * 
     * @return 更新完成的教师信息
     * 
     */
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo);

    /**
     * 删除教师信息。<br>
     * 管理员与合作商可以删除教师信息
     * 
     * @param classPhotoBo
     *            需要删除的教师信息
     * @param userBo
     *            发起删除的管理员/合作商信息
     * 
     * @return 删除完成的教师信息
     * 
     */
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo);

    /**
     * 查询教师信息。<br>
     * 管理员与合作商可以查询教师信息
     * 
     * @param classPhotoBo
     *            需要查询的教师信息
     * @param partnerBo
     *            教师相关的合作商信息
     * @param userBo
     *            发起查询的用户信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 推广信息实体 ClassPhoto 列表
     * 
     */
    public List<ClassPhotoBo> query(ClassPhotoBo classPhotoBo, UserBo userBo, PaginationBo paginationBo);

    /**
     * 查询教师信息。<br>
     * 管理员与合作商可以查询教师信息
     * 
     * @param partnerId
     *            需要查询的教师信息
     * 
     * @return 推广信息实体 ClassPhoto 列表
     * 
     */
    public List<ClassPhotoBo> listByPartnerId(int partnerId, UserBo userBo);

    /**
     * 查询教师信息。<br>
     * 管理员与合作商可以查询教师信息
     * 
     * @param partnerId
     *            需要查询的教师信息
     * 
     * @return 推广信息实体 ClassPhoto 列表
     * 
     */
    public List<ClassPhotoBo> listByCourseId(int courseId);

    /**
     * 查询教师信息。<br>
     * 管理员与合作商可以查询教师信息
     * 
     * @param partnerId
     *            需要查询的教师信息
     * 
     * @return 推广信息实体 ClassPhoto 列表
     * 
     */
    public List<ClassPhotoBo> listByCourseTemplateId(int courseTemplateId);
}