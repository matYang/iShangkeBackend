package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.web.model.LoginVo;

public class LoginConverter {
    public static LoginBo fromModel(LoginVo vo) {
        if (vo == null) {
            return null;
        }
        LoginBo bo = new LoginBo();
        bo.setId(vo.getId());
        bo.setAccountIdentifier(vo.getAccountIdentifier());
        bo.setPassword(vo.getPassword());
        return bo;
    }
}
