package com.example.datascience.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA-256 算法工具类
 */
public class SHA256Utils {

    /**
     * 生成签名
     * @param bytes
     * @return
     */
    public static String getToken(byte[] bytes) {
        return getToken(byte2Hex(bytes));
    }

    /**
     * 生成签名
     * @param source
     * @return
     */
    public static String getToken(String source) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(source.getBytes("UTF-8"));
            String signature = byte2Hex(messageDigest.digest());
            return signature;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp;
        for(byte b : bytes) {
            tmp = Integer.toHexString(b & 0xff);
            if (tmp.length() == 0) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
}
