package com.ishangke.edunav.manager.alipay;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

    // 商家ID
    public static String partner = "2088511319628145";

    // 商户的私钥
    public static String key = "iwtilotw6cdxsvfw4qqk3n07feqplgh8";

    // 卖家支付宝用户号
    public static String seller_id = "2088511319628145";
    // 调试用，创建TXT日志文件夹路径
    public static String log_path = "";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "utf-8";

    // 签名方式 不需修改
    public static String sign_type = "MD5";

    // 超时时间
    public static String it_b_pay = "1h";
    // notify_url 交易过程中服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
    //正式上线之后需要修改
    public static String notify_url = "http://usertest.ishangke.cn/api/v2/alipay/notify_Url";

    // 付完款后跳转的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
    // return_url的域名不能写成http://localhost/js_jsp_utf8/return_url.jsp，否则会导致return_url执行无效
    //public static String return_url ="http://usertest.ishangke.cn/api/v2/alipay/alipay/return_Url";
    public static String return_url = "";

    // payment_type 默认为1
    public static String payment_type = "1";

    // transport
    public static String transport = "https";

    public static String successRedirect = "http://usertest.ishangke.cn/alipay/success.html";

    public static String failureRedirect = "http://usertest.ishangke.cn/alipay/fail.html";

}