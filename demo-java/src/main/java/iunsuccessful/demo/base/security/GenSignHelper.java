package iunsuccessful.demo.base.security;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * 签名工具类
 * @company aikucun.com
 *
 */
public class GenSignHelper {
    public static void main(String[] args) {
        //使用方法
        String host = "http://openapi.ikucun.com";
        String url = "/api/v1/order";
        //1、公共参数
        String appid = "test0001";
        String appsecret = "test00011000test";
        String noncestr = "32412423";
        String erp = "e3";
        String erpVersion = "1.0";
        // https://openapi.akucun.com/api/v2/order/listall?version=2?
        // activityid=1102844350884954113aaaaaaaaaaaaa
        // &appid=2c93811569566207016957448a720018
        // &erp=ThreeSquirrels
        // &erpversion=1.0
        // &noncestr=96347403
        // &page=1
        // &pagesize=100
        // &timestamp=1555999472
        // &withwaybill=0
        // &sign=73f2221d65cec59f2dae84001619632d0d656fd4
        //2、GET请求参数
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("activityid", "1102844350884954113aaaaaaaaaaaaa");
        queryMap.put("appid", "2c93811569566207016957448a720018");
        queryMap.put("erp", "ThreeSquirrels");
        queryMap.put("erpversion", "1.0");
        queryMap.put("noncestr", "77586964");
        queryMap.put("page", "1");
        queryMap.put("pagesize", "100");
        queryMap.put("timestamp", "1556000833");
        queryMap.put("withwaybill", "0");
        queryMap.put("appsecret", "2c93811569566207016957448bf70019");
        //3、POST请求参数
        String jsonString = "{\"type\":\"中文\"}";
        String timestamp = String.valueOf(System.currentTimeMillis()/1000);
        //4、求出签名和请求串
        String[] rets = GenSignHelper.genSign(appid, appsecret, noncestr, erp, erpVersion,timestamp,
                queryMap, jsonString);//如果非POST请求则最后一个参数jsonString为null即可
        System.out.println("签名是: " + rets[0]);
        System.out.println("GET请求参数是（已带上签名key）: " + rets[1]);
        System.out.println("POST请求参数值是: " + rets[2]);
        System.out.println("POST " + host + url + "?" + rets[1]);
        System.out.println("\t" + rets[2]);
    }
    /**
     * 签名方法
     * @param appid
     * @param appsecret
     * @param noncestr
     * @param erp
     * @param erpVersion
     * @param queryParams 跟在URL后面的参数，如果无传null即可.
     * @param jsonString 需要POST的参数，如果没有传null即可
     * @return String[],返回值[0 -  sign, 1 - queryString参数（application/x-www-form-urlencoded），2 - POST内容的参数(application/json)]
     */
    public static String[] genSign(String appid, String appsecret, String noncestr, String erp, String erpVersion,String timestamp,
                                   Map<String, Object> queryParams, String jsonString) {
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> postParams = new HashMap<String, Object>();
//        if(queryParams==null) queryParams = new HashMap<String, Object>();
//        if(jsonString != null && jsonString.length() > 0) {
//            postParams.put("body", jsonString);
//        }
//        Map<String, Object> comonsMap = new HashMap<String, Object>();
//        comonsMap.put("appid", nullSafe(appid));
//        comonsMap.put("noncestr", nullSafe(noncestr));
//        comonsMap.put("timestamp",timestamp);
//        comonsMap.put("erp", nullSafe(erp));
//        comonsMap.put("erpversion", nullSafe(erpVersion));
//        comonsMap.put("appsecret", nullSafe(appsecret));
//        params.putAll(comonsMap);//全部进计算参数中
        params.putAll(queryParams);
//        params.putAll(postParams);
        Object[] arKey = params.keySet().toArray();//取出所有的key
        Arrays.sort(arKey);//对所有的key进行按Ascii码升序排
        StringBuffer buf = new StringBuffer();
        for(Object key : arKey) {
            if(buf.length() > 0) buf.append("&");
            buf.append(key).append("=").append(nullSafe(params.get(key)));//对原值进行串接
        }
        //System.out.println("签名的内容是:" + buf.toString());
        String sig = sha1(buf.toString());//生成SHA1签名
        System.out.println(sig);
//        comonsMap.remove("appsecret");//剔除appsecret
        queryParams.put("sign", sig);//加入自签名
//        queryParams.putAll(comonsMap);//加入全局参数
        return new String[] {sig, map2urlencode(queryParams), jsonString};
    }
    private static String nullSafe(Object o) {
        return o==null ? "" : o.toString();
    }
    /**
     * 对所有key进行application/x-www-form-urlencoded格式的封装
     * @param dataMap
     * @return
     */
    public static String map2urlencode(Map<String, Object> dataMap) {
        StringBuffer buf = new StringBuffer();
        Set<String> namesSet = dataMap.keySet();
        for(String name : namesSet) {
            if(buf.length() > 0) buf.append("&");
            try {
                buf.append(name).append("=").append(URLEncoder.encode(nullSafe(dataMap.get(name)), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return buf.toString();
    }
    public static String sha1(String text) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(text.getBytes());
            outStr = byteToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return outStr;
    }
    private static String byteToString(byte[] digest) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }
}