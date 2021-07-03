package com.herenpeng.json.util;

import com.herenpeng.json.content.PropertyInfo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class ObjectUtils {

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        Class<?> objectClass = object.getClass();
        if (objectClass == String.class) {
            String str = (String) object;
            return StringUtils.isEmpty(str);
        }
        if (objectClass.isAssignableFrom(Collection.class)) {
            Collection collection = (Collection) object;
            return CollectionUtils.isEmpty(collection);
        }
        if (object.getClass().isArray()) {
            Object[] objects = (Object[]) object;
            return ArrayUtils.isEmpty(objects);
        }
        return false;
    }


    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static List<PropertyInfo> getPropertyInfo(Class<?> objectClass) throws IntrospectionException {
        List<PropertyInfo> list = new ArrayList<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(objectClass);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : pds) {
            if ("class".equals(property.getName())) {
                continue;
            }
            PropertyInfo info = new PropertyInfo();
            info.setName(property.getName());
            info.setReadMethod(property.getReadMethod());
            info.setWriteMethod(property.getWriteMethod());
            list.add(info);
        }
        return list;
    }


}
