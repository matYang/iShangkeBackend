package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.web.model.LoginVo;

public class LoginConverter {
    public static LoginBo fromModel(LoginVo vo) {
        if (vo == null) {
            return null;
        }
        LoginBo bo = new LoginBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        if (vo.getAccountIdentifier() != null) {
            bo.setAccountIdentifier(vo.getAccountIdentifier());
        }
        if (vo.getPassword() != null) {
            bo.setPassword(vo.getPassword());
        }
        return bo;
    }
}
