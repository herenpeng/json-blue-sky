package com.herenpeng.json.util;

import java.util.Collection;

/**
 * 集合工具类
 *
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class CollectionUtils {

    /**
     * 判断一个集合是否为空，或者没有元素
     *
     * @param collection 集合
     * @return 集合是否为空，或者没有元素返回true
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }


    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

}
