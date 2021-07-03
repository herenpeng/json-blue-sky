package com.herenpeng.json.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类型工具类
 *
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class TypeUtils {

    /**
     * 判断一个 Java 类型是否是 Json 中的数字类型
     *
     * @param objectClass Java 类型字节码对象
     * @return Java 类型是否是 Json 中的数字类型返回true，否则返回false
     */
    public static boolean isJsonTypeNumber(Class<?> objectClass) {
        return objectClass == Byte.class ||
                objectClass == Short.class ||
                objectClass == Integer.class ||
                objectClass == Long.class ||
                objectClass == Float.class ||
                objectClass == Double.class;
    }

    public static boolean isJsonTypeBoolean(Class<?> objectClass) {
        return objectClass == Boolean.class;
    }

    public static boolean isJsonTypeString(Class<?> objectClass) {
        return objectClass == Character.class ||
                objectClass == String.class ||
                objectClass == BigDecimal.class ||
                objectClass == Date.class;
    }

    public static boolean isJavaTypeObject(String json) {
        return json.startsWith("{") && json.endsWith("}");
    }


}
