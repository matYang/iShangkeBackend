package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo toBo(ApproveHistoryEntityExt e) {
        ApproveHistoryBo approveHistoryBo = new ApproveHistoryBo();
        if (e.getApproveUserId() != null) {
            approveHistoryBo.setApproveUserId(e.getApproveUserId());
        }
        if (e.getApproveUserIdSet() != null) {
            approveHistoryBo.setApproveUserIdSet(e.getApproveUserIdSet());
        }
        if (e.getAttachedId() != null) {
            approveHistoryBo.setAttachedId(e.getAttachedId());
        }
        if (e.getAttachedIdSet() != null) {
            approveHistoryBo.setAttachedIdSet(e.getAttachedIdSet());
        }
        if (e.getComment() != null) {
            approveHistoryBo.setComment(e.getComment());
        }
        if (e.getId() != null) {
            approveHistoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            approveHistoryBo.setIdSet(e.getIdSet());
        }
        if (e.getPostStatus() != null) {
            approveHistoryBo.setPostStatus(e.getPostStatus());
        }
        if (e.getPostStatusSet() != null) {
            approveHistoryBo.setPostStatusSet(e.getPostStatusSet());
        }
        if (e.getPreStatus() != null) {
            approveHistoryBo.setPreStatus(e.getPreStatus());
        }
        if (e.getPreStatusSet() != null) {
            approveHistoryBo.setPreStatusSet(e.getPreStatusSet());
        }
        if (e.getSubmitUserId() != null) {
            approveHistoryBo.setSubmitUserId(e.getSubmitUserId());
        }
        if (e.getSubmitUserIdSet() != null) {
            approveHistoryBo.setSubmitUserIdSet(e.getSubmitUserIdSet());
        }
        if (e.getType() != null) {
            approveHistoryBo.setType(e.getType());
        }
        if (e.getTypeSet() != null) {
            approveHistoryBo.setTypeSet(e.getTypeSet());
        }
        approveHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        approveHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        approveHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        return approveHistoryBo;
    }

    public static ApproveHistoryEntityExt fromBo(ApproveHistoryBo bo) {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        approveHistoryEntityExt.setApproveUserId(bo.getApproveUserId());
        approveHistoryEntityExt.setApproveUserIdSet(bo.getApproveUserIdSet());
        approveHistoryEntityExt.setAttachedId(bo.getAttachedId());
        approveHistoryEntityExt.setAttachedIdSet(bo.getAttachedIdSet());
        approveHistoryEntityExt.setComment(bo.getComment());
        approveHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        approveHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        approveHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        approveHistoryEntityExt.setId(bo.getId());
        approveHistoryEntityExt.setIdSet(bo.getIdSet());
        approveHistoryEntityExt.setPostStatus(bo.getPostStatus());
        approveHistoryEntityExt.setPostStatusSet(bo.getPostStatusSet());
        approveHistoryEntityExt.setPreStatus(bo.getPreStatus());
        approveHistoryEntityExt.setPreStatusSet(bo.getPreStatusSet());
        approveHistoryEntityExt.setSubmitUserId(bo.getSubmitUserId());
        approveHistoryEntityExt.setSubmitUserIdSet(bo.getSubmitUserIdSet());
        approveHistoryEntityExt.setType(bo.getType());
        approveHistoryEntityExt.setTypeSet(bo.getTypeSet());
        return approveHistoryEntityExt;
    }
}
