package com.ishangke.edunav.manager.alipay;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlipayCore {

    /**
     * 功能：生成签名结果
     * 
     * @param sArray
     *            要签名的数组
     * @param key
     *            安全校验码
     * @return 签名结果字符串
     */
    public static String BuildMysign(Map<String, String> sArray) {
        String prestr = CreateLinkString(sArray); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        prestr = prestr + AlipayConfig.key; // 把拼接后的字符串再与安全校验码直接连接起来
        String mysign = Md5Encrypt.md5(prestr);
        return mysign;
    }

    /**
     * 功能：除去数组中的空值和签名参数
     * 
     * @param sArray
     *            签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> ParaFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 功能：把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * 
     * @param params
     *            需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String CreateLinkString(Map<String, String> params) {
        List keys = new ArrayList(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            String value = (String) params.get(key);

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * 功能：写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * 
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void LogResult(String sWord) {
        // 该文件存在于和应用服务器 启动文件同一目录下，文件名是alipay log加服务器时间
        try {
            FileWriter writer = new FileWriter("D:\\alipay_log" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
