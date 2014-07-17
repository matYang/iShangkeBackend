package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.web.user.model.ContactVo;

public class ContactConverter {
    public static ContactBo fromModel(ContactVo e) {
        ContactBo contactBo = new ContactBo();
        return contactBo;
    }

    public static ContactVo toModel(ContactBo bo) {
        ContactVo contactVo = new ContactVo();
        return contactVo;
    }
}
