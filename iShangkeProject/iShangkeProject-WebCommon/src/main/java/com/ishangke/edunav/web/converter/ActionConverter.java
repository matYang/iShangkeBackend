package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.web.common.ActionVo;

public class ActionConverter {
    public static ActionBo fromModel(ActionVo vo) {
        ActionBo actionBo = new ActionBo();
        actionBo.setName(vo.getName());
        return actionBo;
    }

    public static ActionVo toModel(ActionBo bo) {
        ActionVo actionVo = new ActionVo();
        actionVo.setName(bo.getName());
        return actionVo;
    }
}
