package com.herenpeng.json.core;

import com.herenpeng.json.JsonHelper;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class ArraySerializable implements JsonSerializable {

    @Override
    public String write(Object object) {
        Object[] arr = (Object[]) object;
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Object o : arr) {
            jsonHelper.toJson(o);
        }
        json.append("]");
        return json.toString();
    }
}
