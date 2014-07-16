package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;

public class ContactConverter {
    public static ContactBo toBo(ContactEntityExt e) {
        return new ContactBo();
    }

    public static ContactEntityExt fromBo(ContactBo bo) {
        return new ContactEntityExt();
    }
}
