package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;

public class ContactConverter {
    public static ContactBo toBo(ContactEntityExt e) {
        ContactBo contactBo = new ContactBo();
        return contactBo;
    }

    public static ContactEntityExt fromBo(ContactBo bo) {
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        return contactEntityExt;
    }
}
