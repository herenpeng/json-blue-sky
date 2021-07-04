package com.herenpeng.json.core;

import com.herenpeng.json.JsonHelper;
import com.herenpeng.json.worker.JsonWorker;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class ArraySerializable extends JsonWorker implements JsonSerializable {

    @Override
    public String write(Object object) {
        Object[] arr = (Object[]) object;
        boolean first = true;
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Object obj : arr) {
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
