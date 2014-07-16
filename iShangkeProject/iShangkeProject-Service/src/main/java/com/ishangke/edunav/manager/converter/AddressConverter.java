package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public class AddressConverter {
    public static AddressBo toBo(AddressEntityExt e) {
        return new AddressBo();
    }

    public static AddressEntityExt fromBo(AddressBo bo) {
        return new AddressEntityExt();
    }
}
