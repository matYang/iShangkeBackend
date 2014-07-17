package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.web.user.model.WithdrawVo;

public class WithdrawConverter {
    public static WithdrawBo fromModel(WithdrawVo e) {
        WithdrawBo withdrawBo = new WithdrawBo();
        return withdrawBo;
    }

    public static WithdrawVo toModel(WithdrawBo bo) {
        WithdrawVo withdrawVo =new WithdrawVo();
        return withdrawVo;
    }
}
