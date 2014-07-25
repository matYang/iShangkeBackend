package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.web.model.ApproveHistoryVo;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo fromModel(ApproveHistoryVo vo) {
        ApproveHistoryBo approveHistoryBo = new ApproveHistoryBo();
        if (vo.getApproveUserId() != null) {
            approveHistoryBo.setApproveUserId(vo.getApproveUserId());
        }
        if (vo.getApproveUserIdSet() != null) {
            approveHistoryBo.setApproveUserIdSet(vo.getApproveUserIdSet());
        }
        if (vo.getAttachedId() != null) {
            approveHistoryBo.setAttachedId(vo.getAttachedId());
        }
        if (vo.getAttachedIdSet() != null) {
            approveHistoryBo.setAttachedIdSet(vo.getAttachedIdSet());
        }
        if (vo.getComment() != null) {
            approveHistoryBo.setComment(vo.getComment());
        }
        if (vo.getId() != null) {
            approveHistoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            approveHistoryBo.setIdSet(vo.getIdSet());
        }
        if (vo.getPostStatus() != null) {
            approveHistoryBo.setPostStatus(vo.getPostStatus());
        }
        if (vo.getPostStatusSet() != null) {
            approveHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        }
        if (vo.getPreStatus() != null) {
            approveHistoryBo.setPreStatus(vo.getPreStatus());
        }
        if (vo.getPreStatusSet() != null) {
            approveHistoryBo.setPreStatusSet(vo.getPreStatusSet());
        }
        if (vo.getSubmitUserId() != null) {
            approveHistoryBo.setSubmitUserId(vo.getSubmitUserId());
        }
        if (vo.getSubmitUserIdSet() != null) {
            approveHistoryBo.setSubmitUserIdSet(vo.getSubmitUserIdSet());
        }
        if (vo.getType() != null) {
            approveHistoryBo.setType(vo.getType());
        }
        if (vo.getTypeSet() != null) {
            approveHistoryBo.setTypeSet(vo.getTypeSet());
        }
        approveHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        approveHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        approveHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
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
