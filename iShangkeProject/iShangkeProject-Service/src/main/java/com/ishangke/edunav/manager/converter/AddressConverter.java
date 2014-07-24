package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public class AddressConverter {
   public static AddressBo toBo(AddressEntityExt e) {
       AddressBo addressBo = new AddressBo();
       addressBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
       addressBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
       addressBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
       addressBo.setDetail(e.getDetail());
       addressBo.setEnabled(e.getEnabled());
       addressBo.setId(e.getId());
       addressBo.setIdSet(e.getIdSet());
       addressBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
       addressBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
       addressBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
       addressBo.setLat(e.getLat());
       addressBo.setLatEnd(e.getLatEnd());
       addressBo.setLatStart(e.getLatStart());
       addressBo.setLng(e.getLng());
       addressBo.setLngEnd(e.getLngEnd());
       addressBo.setLngStart(e.getLngStart());
       addressBo.setPartnerId(e.getPartnerId());
       addressBo.setPartnerIdSet(e.getPartnerIdSet());
       return addressBo;
   }

   public static AddressEntityExt fromBo(AddressBo bo) {
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
       addressEntityExt.setLat(bo.getLat());
       addressEntityExt.setLatEnd(bo.getLatEnd());
       addressEntityExt.setLatStart(bo.getLatStart());
       addressEntityExt.setLng(bo.getLng());
       addressEntityExt.setLngEnd(bo.getLngEnd());
       addressEntityExt.setLngStart(bo.getLngStart());
       addressEntityExt.setPartnerId(bo.getPartnerId());
       addressEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
       return addressEntityExt;
   }
}
