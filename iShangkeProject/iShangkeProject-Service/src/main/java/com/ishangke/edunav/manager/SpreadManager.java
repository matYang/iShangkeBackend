package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface SpreadManager {

    /**
     * 生成识别码。<br>
     * 每条推广信息都需要独立的识别码
     * 
     * @param userBo
     *            发布推广信息的用户
     * @param partnerBo
     *            用户推广的机构信息
     * @param courseBo
     *            用户推广的课程信息
     * @param iShangkeBo
     *            用户推广的爱上课信息
     * 
     * @return 创建完毕的识别码
     * 
     * 
     * @param userBo
     * @param partnerBo
     * @param courseBo
     */
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 查询推广信息。<br>
     * 管理员可以查询推广信息
     * 
     * @param spreadBo
     *            需要查询的推广信息
     * @param userBo
     *            推广相关的用户信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 推广信息实体 SpreadBo 列表
     * 
     * 
     * @param spreadBo
     * @param userBo
     * @param paginationBo
     */
    public List<SpreadBo> query(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 创建推广信息。<br>
     * 用户可以创建推广信息，以供管理员审查
     * 
     * @param spreadBo
     *            需要创建的推广信息
     * @param partnerBo
     *            用户推广的机构信息
     * @param courseBo
     *            用户推广的课程信息
     * @param iShangkeBo
     *            用户推广的爱上课信息
     * @param userBo
     *            发布推广信息的用户
     * 
     * @return 创建完毕的推广信息
     * 
     * 
     * @param spreadBo
     * @param partnerBo
     * @param courseBo
     * @param userBo
     */
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 认可推广信息。<br>
     * 管理员可以审核认可用户发布的推广信息
     * 
     * @param spreadBo
     *            待认可的推广信息
     * @param userBo
     *            发起认可的管理员信息
     * 
     * @return 认可之后的推广信息
     * 
     * 
     * @param spreadBo
     * @param userBo
     */
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 拒绝推广信息。<br>
     * 管理员可以审核拒绝用户发布的推广信息
     * 
     * @param spreadBo
     *            待拒绝的推广信息
     * @param userBo
     *            发起拒绝的管理员信息
     * 
     * @return 拒绝之后的推广信息
     * 
     * 
     * @param spreadBo
     * @param userBo
     */
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 取消推广信息。<br>
     * 用户可以取消待审核的推广信息
     * 
     * @param spreadBo
     *            待取消的推广信息
     * @param userBo
     *            发起取消的用户信息
     * 
     * @return 取消之后的推广信息
     * 
     * 
     * @param spreadBo
     * @param userBo
     */
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 删除推广信息。<br>
     * 用户可以删除推广信息记录
     * 
     * @param spreadBo
     *            待删除的推广信息
     * @param userBo
     *            发起删除的用户信息
     * 
     * @return 删除之后的推广信息
     * 
     * 
     * @param spreadBo
     * @param userBo
     */
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

}
