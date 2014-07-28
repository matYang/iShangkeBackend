package com.ishangke.edunav.web.user.vo;

public class AlipayVo {

    private String notify_id;
    private String out_trade_no;
    private String trade_status;
    private String notify_time;
    
    public String getNotify_id() {
        return notify_id;
    }
    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getTrade_status() {
        return trade_status;
    }
    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }
    public String getNotify_time() {
        return notify_time;
    }
    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }
    
}
