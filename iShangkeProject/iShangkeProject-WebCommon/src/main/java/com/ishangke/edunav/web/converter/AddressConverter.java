package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.web.model.AddressVo;

public class AddressConverter {
    public static AddressBo fromModel(AddressVo vo) {
        if (vo == null) {
            return null;
        }
        AddressBo addressBo = new AddressBo();
        if (vo.getDetail() != null) {
            addressBo.setDetail(vo.getDetail());
        }
        if (vo.getEnabled() != null) {
            addressBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            addressBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            addressBo.setIdSet(vo.getIdSet());
        }
        if (vo.getLat() != null) {
            addressBo.setLat(vo.getLat());
        } else {
            addressBo.setLat(Constant.DEFAULTNULL);
        }
        if (vo.getLatEnd() != null) {
            addressBo.setLatEnd(vo.getLatEnd());
        } else {
            addressBo.setLatEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLatStart() != null) {
            addressBo.setLatStart(vo.getLatStart());
        } else {
            addressBo.setLatStart(Constant.DEFAULTNULL);
        }
        if (vo.getLng() != null) {
            addressBo.setLng(vo.getLng());
        } else {
            addressBo.setLng(Constant.DEFAULTNULL);
        }
        if (vo.getLngEnd() != null) {
            addressBo.setLngEnd(vo.getLngEnd());
        } else {
            addressBo.setLngEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLngStart() != null) {
            addressBo.setLngStart(vo.getLngStart());
        } else {
            addressBo.setLngStart(Constant.DEFAULTNULL);
        }
        if (vo.getPartnerId() != null) {
            addressBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            addressBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        addressBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        addressBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        addressBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        addressBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        addressBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        addressBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return addressBo;
    }

    public static AddressVo toModel(AddressBo bo) {
        if (bo == null) {
            return null;
        }
        AddressVo addressVo = new AddressVo();
        addressVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        addressVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        addressVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        addressVo.setDetail(bo.getDetail());
        addressVo.setEnabled(bo.getEnabled());
        addressVo.setId(bo.getId());
        addressVo.setIdSet(bo.getIdSet());
        addressVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        addressVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        addressVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        if (Constant.DEFAULTNULL != bo.getLat()) {
            addressVo.setLat(bo.getLat());
        }
        if (Constant.DEFAULTNULL != bo.getLatEnd()) {
            addressVo.setLatEnd(bo.getLatEnd());
        }
        if (Constant.DEFAULTNULL != bo.getLatStart()) {
            addressVo.setLatStart(bo.getLatStart());
        }
        if (Constant.DEFAULTNULL != bo.getLng()) {
            addressVo.setLng(bo.getLng());
        }
        if (Constant.DEFAULTNULL != bo.getLngEnd()) {
            addressVo.setLngEnd(bo.getLngEnd());
        }
        if (Constant.DEFAULTNULL != bo.getLngStart()) {
            addressVo.setLngStart(bo.getLngStart());
        }
        addressVo.setPartnerId(bo.getPartnerId());
        addressVo.setPartnerIdSet(bo.getPartnerIdSet());
        return addressVo;
    }
}
