package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;

public class WithdrawConverter {
    public static WithdrawBo toBo(WithdrawEntityExt e) {
        WithdrawBo withdrawBo = new WithdrawBo();
        return withdrawBo;
    }

    public static WithdrawEntityExt fromBo(WithdrawBo bo) {
        WithdrawEntityExt withdrawEntityExt =new WithdrawEntityExt();
        return withdrawEntityExt;
    }
}
