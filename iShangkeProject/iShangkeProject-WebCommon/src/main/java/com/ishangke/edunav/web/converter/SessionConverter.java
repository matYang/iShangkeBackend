package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.web.model.SessionVo;

public class SessionConverter {
    public static SessionBo fromMode(SessionVo vo) {
        SessionBo bo = new SessionBo();
        if (vo == null) {
            return null;
        }
        bo.setAccountIdentifier(vo.getAccountIdentifier());
        bo.setAuthCode(vo.getAuthCode());
        bo.setId(vo.getId());
        return bo;
    }
    
    public static SessionVo toModel(SessionBo bo) {
        SessionVo vo = new SessionVo();
        if (bo == null) {
            return null;
        }
        vo.setAccountIdentifier(bo.getAccountIdentifier());
        vo.setAuthCode(bo.getAuthCode());
        vo.setId(bo.getId());
        return vo;
    }
}
