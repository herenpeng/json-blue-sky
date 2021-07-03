package com.herenpeng.json.core;

import com.herenpeng.json.JsonHelper;

import java.util.Collection;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class CollectionSerializable implements JsonSerializable {

    @Override
    public String write(Object object) {
        Collection collection = (Collection) object;
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Object o : collection) {
            jsonHelper.toJson(o);
        }
        json.append("]");
        return json.toString();
    }
}
