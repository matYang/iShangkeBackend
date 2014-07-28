package com.ishangke.edunav.manager.impl;

import com.ishangke.edunav.manager.AlipayManager;
import com.ishangke.edunav.manager.caiwu.alipay.AlipayNotify;
import com.ishangke.edunav.manager.caiwu.alipay.AlipaySubmit;

public class AlipayManagerImpl implements AlipayManager{

    @Override
    public String verify(String notify_id) {
       return AlipayNotify.Verify(notify_id);
    }

    @Override
    public String getSubmit(String subject, String out_trade_no, String total_fee) {
        return AlipaySubmit.buildFormForGet(out_trade_no, subject, total_fee);
    }

}
