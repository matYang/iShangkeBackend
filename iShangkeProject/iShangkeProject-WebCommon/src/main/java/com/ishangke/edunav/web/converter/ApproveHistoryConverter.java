package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.web.model.ApproveHistoryVo;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo fromModel(ApproveHistoryVo vo) {
        ApproveHistoryBo approveHistoryBo = new ApproveHistoryBo();
        approveHistoryBo.setApproveUserId(vo.getApproveUserId());
        approveHistoryBo.setApproveUserIdSet(vo.getApproveUserIdSet());
        approveHistoryBo.setAttachedId(vo.getAttachedId());
        approveHistoryBo.setAttachedIdSet(vo.getAttachedIdSet());
        approveHistoryBo.setComment(vo.getComment());
        approveHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        approveHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        approveHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        approveHistoryBo.setId(vo.getId());
        approveHistoryBo.setIdSet(vo.getIdSet());
        approveHistoryBo.setPostStatus(vo.getPostStatus());
        approveHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        approveHistoryBo.setPreStatus(vo.getPreStatus());
        approveHistoryBo.setPreStatusSet(vo.getPreStatusSet());
        approveHistoryBo.setSubmitUserId(vo.getSubmitUserId());
        approveHistoryBo.setSubmitUserIdSet(vo.getSubmitUserIdSet());
        approveHistoryBo.setType(vo.getType());
        approveHistoryBo.setTypeSet(vo.getTypeSet());
        return approveHistoryBo;
    }

    public static ApproveHistoryVo toModel(ApproveHistoryBo bo) {
        ApproveHistoryVo approveHistoryVo = new ApproveHistoryVo();
        approveHistoryVo.setApproveUserId(bo.getApproveUserId());
        approveHistoryVo.setApproveUserIdSet(bo.getApproveUserIdSet());
        approveHistoryVo.setAttachedId(bo.getAttachedId());
        approveHistoryVo.setAttachedIdSet(bo.getAttachedIdSet());
        approveHistoryVo.setComment(bo.getComment());
        approveHistoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        approveHistoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        approveHistoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        approveHistoryVo.setId(bo.getId());
        approveHistoryVo.setIdSet(bo.getIdSet());
        approveHistoryVo.setPostStatus(bo.getPostStatus());
        approveHistoryVo.setPostStatusSet(bo.getPostStatusSet());
        approveHistoryVo.setPreStatus(bo.getPreStatus());
        approveHistoryVo.setPreStatusSet(bo.getPreStatusSet());
        approveHistoryVo.setSubmitUserId(bo.getSubmitUserId());
        approveHistoryVo.setSubmitUserIdSet(bo.getSubmitUserIdSet());
        approveHistoryVo.setType(bo.getType());
        approveHistoryVo.setTypeSet(bo.getTypeSet());
        return approveHistoryVo;
    }
}
