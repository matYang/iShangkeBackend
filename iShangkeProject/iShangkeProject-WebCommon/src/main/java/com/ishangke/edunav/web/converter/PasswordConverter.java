package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.web.model.PasswordVo;

public class PasswordConverter {
    public static PasswordBo fromModel(PasswordVo vo) {
        if (vo == null) {
            return null;
        }
        PasswordBo bo = new PasswordBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        bo.setAccountIdentifier(vo.getAccountIdentifier());
        bo.setAuthCode(vo.getAuthCode());
        bo.setNewPassword(vo.getNewPassword());
        bo.setOldPassword(vo.getOldPassword());
        return bo;
    }
}
