package com.herenpeng.json.util;

/**
 * 字符串工具类
 *
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class StringUtils {

    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * 判断一个字符串是否为空，为null
     *
     * @param str 字符串
     * @return 字符串为空，为null，返回true
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || EMPTY_STRING.equals(str);
    }


    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


}
