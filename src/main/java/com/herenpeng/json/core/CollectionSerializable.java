package com.herenpeng.json.core;

import com.herenpeng.json.JsonHelper;
import com.herenpeng.json.worker.JsonWorker;

import java.util.Collection;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class CollectionSerializable extends JsonWorker implements JsonSerializable {

    @Override
    public String write(Object object) {
        Collection collection = (Collection) object;
        boolean first = true;
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Object obj : collection) {
            if (first) {
                first = false;
            } else {
                json.append(",");
            }
            json.append(getWriter().write(obj));
        }
        json.append("]");
        return json.toString();
    }
}
