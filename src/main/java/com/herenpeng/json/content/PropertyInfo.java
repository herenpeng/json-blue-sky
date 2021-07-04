package com.herenpeng.json.content;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Java 对象的属性相关参数
 *
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class PropertyInfo implements Serializable {

    /**
     * 属性名称
     */
    private String name;
    /**
     * 读方法，比如get方法，is方法
     */
    private Method readMethod;
    /**
     * 写方法，比如set方法
     */
    private Method writeMethod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getReadMethod() {
        return readMethod;
    }

    public void setReadMethod(Method readMethod) {
        this.readMethod = readMethod;
    }

    public Method getWriteMethod() {
        return writeMethod;
    }

    public void setWriteMethod(Method writeMethod) {
        this.writeMethod = writeMethod;
    }

}
