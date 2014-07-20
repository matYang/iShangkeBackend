package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.web.user.model.AddressVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class AddressConverter {
   public static AddressBo fromModel(AddressVo vo) {
       AddressBo addressBo = new AddressBo();
       addressBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
       addressBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
       addressBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
       addressBo.setDetail(vo.getDetail());
       addressBo.setEnabled(vo.getEnabled());
       addressBo.setId(vo.getId());
       addressBo.setIdSet(vo.getIdSet());
       addressBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
       addressBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
       addressBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
       addressBo.setLat(vo.getLat());
       addressBo.setLatEnd(vo.getLatEnd());
       addressBo.setLatStart(vo.getLatStart());
       addressBo.setLng(vo.getLng());
       addressBo.setLngEnd(vo.getLngEnd());
       addressBo.setLngStart(vo.getLngStart());
       addressBo.setPartnerId(vo.getPartnerId());
       addressBo.setPartnerIdSet(vo.getPartnerIdSet());
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
