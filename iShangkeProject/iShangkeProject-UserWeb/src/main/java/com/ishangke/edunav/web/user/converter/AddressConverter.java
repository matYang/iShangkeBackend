package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.web.user.model.AddressVo;

public class AddressConverter {
   public static AddressBo fromModel(AddressVo e) {
       AddressBo addressBo = new AddressBo();
       return addressBo;
   }

   public static AddressVo toModel(AddressBo bo) {
       AddressVo addressVo = new AddressVo();
       return addressVo;
   }
}
