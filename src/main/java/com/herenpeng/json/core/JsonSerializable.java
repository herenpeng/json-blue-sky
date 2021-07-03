package com.herenpeng.json.core;

import com.herenpeng.json.JsonHelper;

import java.util.Collection;
import java.util.Map;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public interface JsonSerializable {

    JsonHelper jsonHelper = new JsonHelper();

    /**
     * 将Json字符串转换为Java对象
     *
     * @param json Json字符串
     * @return Java对象
     */
    // <T> T read(String json);

    /**
     * 将Java对象转换为Json字符串
     *
     * @param object Java对象
     * @return Json字符串
     */
    String write(Object object);

    /**
     * 根据 objectClass 字节码判断类型对象，获取对应的 Json 序列化实现类工具
     *
     * @param objectClass objectClass 字节码
     * @return 对应的 Json 序列化实现类工具
     */
    static JsonSerializable getJsonSerializable(Class<?> objectClass) {
        if (objectClass.isAssignableFrom(Collection.class)) {
            return new CollectionSerializable();
        }
        if (objectClass.isArray()) {
            return new ArraySerializable();
        }
        if (objectClass.isAssignableFrom(Map.class)) {
            return new MapSerializable();
        }
        return new ObjectSerializable();
    }

    static JsonSerializable getJsonSerializable(Object object) {
        Class<?> objectClass = object.getClass();
        return getJsonSerializable(objectClass);
    }
}
