package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public class AddressConverter {
   public static AddressBo toBo(AddressEntityExt e) {
       AddressBo addressBo = new AddressBo();
       return addressBo;
   }

   public static AddressEntityExt fromBo(AddressBo bo) {
       AddressEntityExt addressEntityExt = new AddressEntityExt();
       return addressEntityExt;
   }
}
