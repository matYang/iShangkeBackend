package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.web.model.AddressVo;

public class AddressConverter {
   public static AddressBo fromModel(AddressVo vo) {
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
       }
       if (vo.getLatEnd() != null) {
            addressBo.setLatEnd(vo.getLatEnd());
       }
       if (vo.getLatStart() != null) {
            addressBo.setLatStart(vo.getLatStart());
       }
       if (vo.getLng() != null) {
            addressBo.setLng(vo.getLng());
       }
       if (vo.getLngEnd() != null) {
            addressBo.setLngEnd(vo.getLngEnd());
       }
       if (vo.getLngStart() != null) {
            addressBo.setLngStart(vo.getLngStart());
       }
       if (vo.getPartnerId() != null) {
            addressBo.setPartnerId(vo.getPartnerId());
       }
       if (vo.getPartnerIdSet() != null) {
            addressBo.setPartnerIdSet(vo.getPartnerIdSet());
       }
       addressBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
       addressBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
       addressBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
       addressBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
       addressBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
       addressBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
       return addressBo;
   }

   public static AddressVo toModel(AddressBo bo) {
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
       addressVo.setLat(bo.getLat());
       addressVo.setLatEnd(bo.getLatEnd());
       addressVo.setLatStart(bo.getLatStart());
       addressVo.setLng(bo.getLng());
       addressVo.setLngEnd(bo.getLngEnd());
       addressVo.setLngStart(bo.getLngStart());
       addressVo.setPartnerId(bo.getPartnerId());
       addressVo.setPartnerIdSet(bo.getPartnerIdSet());
       return addressVo;
   }
}
