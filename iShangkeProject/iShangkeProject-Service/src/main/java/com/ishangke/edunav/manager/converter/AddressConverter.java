package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public class AddressConverter {
    public static AddressBo toBo(AddressEntityExt e) {
        if (e == null) {
            return null;
        }
        AddressBo addressBo = new AddressBo();
        if (e.getDetail() != null) {
            addressBo.setDetail(e.getDetail());
        }
        if (e.getEnabled() != null) {
            addressBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            addressBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            addressBo.setIdSet(e.getIdSet());
        }
        if (e.getLat() != null) {
            addressBo.setLat(e.getLat());
        } else {
            addressBo.setLat(Constant.DEFAULTNULL);
        }
        if (e.getLatEnd() != null) {
            addressBo.setLatEnd(e.getLatEnd());
        } else {
            addressBo.setLatEnd(Constant.DEFAULTNULL);
        }
        if (e.getLatStart() != null) {
            addressBo.setLatStart(e.getLatStart());
        } else {
            addressBo.setLatStart(Constant.DEFAULTNULL);
        }
        if (e.getLng() != null) {
            addressBo.setLng(e.getLng());
        } else {
            addressBo.setLng(Constant.DEFAULTNULL);
        }
        if (e.getLngEnd() != null) {
            addressBo.setLngEnd(e.getLngEnd());
        } else {
            addressBo.setLngEnd(Constant.DEFAULTNULL);
        }
        if (e.getLngStart() != null) {
            addressBo.setLngStart(e.getLngStart());
        } else {
            addressBo.setLngStart(Constant.DEFAULTNULL);
        }
        if (e.getPartnerId() != null) {
            addressBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            addressBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        addressBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        addressBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        addressBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        addressBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        addressBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        addressBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return addressBo;
    }

    public static AddressEntityExt fromBo(AddressBo bo) {
        if (bo == null) {
            return null;
        }
        AddressEntityExt addressEntityExt = new AddressEntityExt();
        addressEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        addressEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        addressEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        addressEntityExt.setDetail(bo.getDetail());
        addressEntityExt.setEnabled(bo.getEnabled());
        addressEntityExt.setId(bo.getId());
        addressEntityExt.setIdSet(bo.getIdSet());
        addressEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        addressEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        addressEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        if (bo.getLat() != Constant.DEFAULTNULL) {
            addressEntityExt.setLat(bo.getLat());
        }
        if (bo.getLatEnd() != Constant.DEFAULTNULL) {
            addressEntityExt.setLatEnd(bo.getLatEnd());
        }
        if (bo.getLatStart() != Constant.DEFAULTNULL) {
            addressEntityExt.setLatStart(bo.getLatStart());
        }
        if (bo.getLng() != Constant.DEFAULTNULL) {
            addressEntityExt.setLng(bo.getLng());
        }
        if (bo.getLngEnd() != Constant.DEFAULTNULL) {
            addressEntityExt.setLngEnd(bo.getLngEnd());
        }
        if (bo.getLngStart() != Constant.DEFAULTNULL) {
            addressEntityExt.setLngStart(bo.getLngStart());
        }
        addressEntityExt.setPartnerId(bo.getPartnerId());
        addressEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        return addressEntityExt;
    }
}
