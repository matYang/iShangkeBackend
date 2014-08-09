package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            addressBo.setCreateTime(vo.getCreateTime());
        } else {
            addressBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            addressBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            addressBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            addressBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            addressBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            addressBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            addressBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            addressBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            addressBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            addressBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            addressBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return addressBo;
    }

    public static AddressVo toModel(AddressBo bo) {
        if (bo == null) {
            return null;
        }
        AddressVo addressVo = new AddressVo();
        addressVo.setCreateTime(bo.getCreateTime());
        addressVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        addressVo.setCreateTimeStart(bo.getCreateTimeStart());
        addressVo.setDetail(bo.getDetail());
        addressVo.setEnabled(bo.getEnabled());
        addressVo.setId(bo.getId());
        addressVo.setIdSet(bo.getIdSet());
        addressVo.setLastModifyTime(bo.getLastModifyTime());
        addressVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        addressVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
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
