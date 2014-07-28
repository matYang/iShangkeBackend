package com.ishangke.edunav.manager;

public interface AlipayManager {

    public String verify(String notify_id);
    public String getSubmit(String subject,String out_trade_no,String total_fee);
}
