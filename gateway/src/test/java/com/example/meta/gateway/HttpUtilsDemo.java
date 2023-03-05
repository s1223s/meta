/*
package com.example.meta.gateway;
package com.chinaums.openapi.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.TreeSet;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinaums.common.utils.http.OkHttpUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import okhttp3.Headers;
import org.junit.jupiter.api.Test;

public class HttpUtilsDemo {
    private static Logger logger = LoggerFactory.getLogger(HttpUtilsDemo.class);
    private static String CHARSET = "UTF-8";

    public static void getSignRaw(JSONObject json, StringBuffer sb) {
        if (json.isArray()) {
            JSONArray arr = JSONArray.fromObject(json);
            for (int i = 0; i < arr.size(); i++) {
                JSONObject o = arr.getJSONObject(i);
                getSignRaw(o, sb);
            }
        } else {
            Set<String> keySet = new TreeSet<String>(json.keySet());
            for (String key : keySet) {
                try {
                    JSONObject a = json.getJSONObject(key);
                    getSignRaw(a, sb);
                } catch (Exception e) {
                    try {
                        JSONArray b = json.getJSONArray(key);
                        for (int j = 0; j < b.size(); j++) {
                            getSignRaw(b.getJSONObject(j), sb);
                        }
                    } catch (Exception e2) {
                        if (isNotBlank(json.getString(key))) {
                            sb.append(json.getString(key));
                        }
                    }

                }
            }

        }
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static String sha256Encrypt(String input) {
        return sha256Encrypt(input, "UTF-8");
    }

    public static String sha256Encrypt(String input, String charset) {

        try {
            return toHex(digest("SHA-256", input.getBytes(charset)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] digest(String algorithm, byte[] bytes) {
        return getDigest(algorithm).digest(bytes);
    }

    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Could not find MessageDigest with algorithm \"" + algorithm + "\"", ex);
        }
    }

    private static String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
        }
        return sb.toString().toUpperCase();
    }

    public static String getSign(JSONObject req, String key, String charset) {
        String sign = null;
        StringBuffer sb = new StringBuffer();
        String rawSign = req.optString("sign");
        req.remove("sign");
        getSignRaw(req, sb);
        sb.append(key);
        int begin = sb.indexOf("\"null\"");
        while (begin != -1) {
            sb.replace(begin, begin + 6, "null");
            begin = sb.indexOf("\"null\"");
        }
        try {
            System.out.println(sb.toString());
            sign = sha256Encrypt(sb.toString());//
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.put("sign", rawSign);
        return sign;
    }





    public static String testPost(String url, String reqJson, String signKey) {
        logger.debug("=================【http请求】url={}, httpEntity={}", url, reqJson);

        String result = null;

        try {
            result = OkHttpUtils.postJson(url, reqJson, Headers.of("signKey", signKey));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.debug("=================【http返回】result={}", result);
        return result;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8088/ums-openApi/syncTranData";


        JSONObject bodyParams = new JSONObject();
        // 公共参数
        bodyParams.put("appKey", "chinaumsandroidpos");
        bodyParams.put("methodVer", "1.0");
        bodyParams.put("nonceStr", "D1K2");

        //业务参数
        bodyParams.put("tranDate", "2018-08-14 12:57:19");
        bodyParams.put("orderNo", "OR10805");
        bodyParams.put("deviceId", "ORG10461");
        bodyParams.put("amount", "0.07");
        bodyParams.put("disamt", "0");

        String signKey = "xyz123";
        bodyParams.put("sign", getSign(bodyParams, signKey, CHARSET));
        System.out.println(bodyParams.toString());
        String result = testPost(url, bodyParams.toString(), signKey);
        System.out.println(result);

    }

}
*/
