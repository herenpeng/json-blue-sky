package com.herenpeng.json.core;

import com.herenpeng.json.content.PropertyInfo;
import com.herenpeng.json.util.DateUtils;
import com.herenpeng.json.util.ObjectUtils;
import com.herenpeng.json.util.TypeUtils;
import com.herenpeng.json.worker.JsonWorker;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class ObjectSerializable extends JsonWorker implements JsonSerializable {

    @Override
    public String write(Object object) {
        Class<?> objectClass = object.getClass();
        if (TypeUtils.isJsonTypeNumber(objectClass) || TypeUtils.isJsonTypeBoolean(objectClass)) {
            return object.toString();
        }
        if (TypeUtils.isJsonTypeString(objectClass)) {
            return writeJsonTypeString(object);
        }
        return writeJsonTypeObject(object);
    }


    private String writeJsonTypeString(Object object) {
        Class<?> objectClass = object.getClass();
        StringBuilder json = new StringBuilder();
        json.append("\"");
        String str = object.toString();
        if (objectClass == Date.class) {
            Date date = (Date) object;
            str = DateUtils.format(date);
        }
        json.append(str);
        json.append("\"");
        return json.toString();
    }

    private String writeJsonTypeObject(Object object) {
        try {
            Class<?> objectClass = object.getClass();
            StringBuilder json = new StringBuilder();
            // 拼接对象内容
            json.append("{");
            boolean firstProperty = true;
            List<PropertyInfo> propertyInfoList = ObjectUtils.getPropertyInfo(objectClass);
            for (PropertyInfo propertyInfo : propertyInfoList) {
                Method readMethod = propertyInfo.getReadMethod();
                // 如果对应的属性没有get方法，不进行json数据格式化
                if (ObjectUtils.isEmpty(readMethod)) {
                    continue;
                }
                if (firstProperty) {
                    firstProperty = false;
                } else {
                    json.append(",");
                }
                String propertyName = propertyInfo.getName();
                json.append("\"").append(propertyName).append("\":");

                Object propertyValue = readMethod.invoke(object);
                String propertyJson = getWriter().write(propertyValue);
                json.append(propertyJson);
            }
            json.append("}");
            return json.toString();
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return "{}";
        }
    }


}
