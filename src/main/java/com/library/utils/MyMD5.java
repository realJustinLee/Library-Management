package com.library.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Java消息摘要算法 MD5 工具类
 *
 */
public class MyMD5 {
    /**
     * 对文本执行 md5 摘要加密, 此算法与 mysql,JavaScript生成的md5摘要进行过一致性对比.
     *
     * @param md5String
     * @return 返回值中的字母为小写
     */
    public static String md5(String md5String) {
        if (null == md5String) {
            md5String = "";
        }
        String md5str = "";
        try {
            // JDK 6 支持以下6种消息摘要算法，不区分大小写
            // md5,sha(sha-1),md2,sha-256,sha-384,sha-512
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(md5String.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuilder builder = new StringBuilder(32);
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    builder.append("0");
                }
                builder.append(Integer.toHexString(i));
            }
            md5str = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5str;
    }

    public static void main(String[] args) {
        String m1 = md5("123");
        System.out.println(m1);
    }
}