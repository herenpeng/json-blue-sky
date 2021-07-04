package com.herenpeng.json.worker;

import com.herenpeng.json.core.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author herenpeng
 * @since 2021-07-03 22:38
 */
public class JsonWorker {

    /**
     * Json 写
     */
    private final JsonWriter writer = new JsonWriter();
    /**
     * Json 读
     */
    private final JsonReader reader = new JsonReader();

    protected JsonWriter getWriter() {
        return writer;
    }

    protected JsonReader getReader() {
        return reader;
    }


    /**
     * 根据 objectClass 字节码判断类型对象，获取对应的 Json 序列化实现类工具
     *
     * @param object object 对象
     * @return 对应的 Json 序列化实现类工具
     */
    protected JsonSerializable getJsonSerializable(Object object) {
        Class<?> objectClass = object.getClass();
        if (Collection.class.isAssignableFrom(objectClass)) {
            return new CollectionSerializable();
        }
        if (objectClass.isArray()) {
            return new ArraySerializable();
        }
        if (Map.class.isAssignableFrom(objectClass)) {
            return new MapSerializable();
        }
        return new ObjectSerializable();
    }


}
