package com.herenpeng.json.core;

import com.herenpeng.json.content.PropertyInfo;
import com.herenpeng.json.util.DateUtils;
import com.herenpeng.json.util.ObjectUtils;
import com.herenpeng.json.util.TypeUtils;

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
public class ObjectSerializable implements JsonSerializable {

    @Override
    public String write(Object object) {
        Class<?> objectClass = object.getClass();
        if (TypeUtils.isJsonTypeNumber(objectClass) || TypeUtils.isJsonTypeBoolean(objectClass)) {
            return object.toString();
        }
        if (TypeUtils.isJsonTypeString(objectClass)) {
            return writeString(object);
        }
        return writeObject(object);
    }


    private static String writeString(Object object) {
        Class<?> objectClass = object.getClass();
        StringBuilder json = new StringBuilder();
        json.append("\"");
        if (objectClass == Date.class) {
            Date date = (Date) object;
            json.append(DateUtils.format(date));
        }
        if (objectClass == BigDecimal.class) {

        }
        json.append("\"");
        return json.toString();
    }

    private static String writeObject(Object object) {
        try {
            Class<?> objectClass = object.getClass();
            StringBuilder json = new StringBuilder();
            json.append("{");
            // 拼接对象内容
            boolean firstProperty = true;
            List<PropertyInfo> propertyInfoList = null;
            propertyInfoList = ObjectUtils.getPropertyInfo(objectClass);
            for (PropertyInfo propertyInfo : propertyInfoList) {
                if (firstProperty) {
                    firstProperty = false;
                } else {
                    json.append(",");
                }
                String propertyName = propertyInfo.getName();
                json.append("\"").append(propertyName).append("\":");
                Method readMethod = propertyInfo.getReadMethod();
                Object propertyValue = readMethod.invoke(object);
                String propertyJson = jsonHelper.toJson(propertyValue);
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
