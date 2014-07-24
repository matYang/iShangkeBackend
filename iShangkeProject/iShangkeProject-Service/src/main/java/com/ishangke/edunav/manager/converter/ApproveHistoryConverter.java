package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo toBo(ApproveHistoryEntityExt e) {
        ApproveHistoryBo approveHistoryBo = new ApproveHistoryBo();
        approveHistoryBo.setApproveUserId(e.getApproveUserId());
        approveHistoryBo.setApproveUserIdSet(e.getApproveUserIdSet());
        approveHistoryBo.setAttachedId(e.getAttachedId());
        approveHistoryBo.setAttachedIdSet(e.getAttachedIdSet());
        approveHistoryBo.setComment(e.getComment());
        approveHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        approveHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        approveHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        approveHistoryBo.setId(e.getId());
        approveHistoryBo.setIdSet(e.getIdSet());
        approveHistoryBo.setPostStatus(e.getPostStatus());
        approveHistoryBo.setPostStatusSet(e.getPostStatusSet());
        approveHistoryBo.setPreStatus(e.getPreStatus());
        approveHistoryBo.setPreStatusSet(e.getPreStatusSet());
        approveHistoryBo.setSubmitUserId(e.getSubmitUserId());
        approveHistoryBo.setSubmitUserIdSet(e.getSubmitUserIdSet());
        approveHistoryBo.setType(e.getType());
        approveHistoryBo.setTypeSet(e.getTypeSet());
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
