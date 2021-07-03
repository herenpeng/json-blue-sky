package com.herenpeng.json.util;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class ArrayUtils {

    /**
     * 判断一个数组是否为空
     *
     * @param objects 数组
     * @return 数组为空或者长度为0返回true，否则返回false
     */
    public static boolean isEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    /**
     * 判断一个数组是否为不为空
     *
     * @param objects 数组
     * @return 数组为空或者长度为0返回false，否则返回true
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

}
