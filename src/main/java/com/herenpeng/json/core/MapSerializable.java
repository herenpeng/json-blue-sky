package com.herenpeng.json.core;

import com.herenpeng.json.worker.JsonWorker;

import java.util.Map;
import java.util.Set;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class MapSerializable extends JsonWorker implements JsonSerializable {


    @Override
    public String write(Object object) {
        Map map = (Map) object;
        Set<Map.Entry> entrySet = map.entrySet();
        boolean first = true;
        StringBuilder json = new StringBuilder();
        json.append("{");
        for (Map.Entry entry : entrySet) {
            Object key = entry.getKey();
            if (String.class != key.getClass()) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                json.append(",");
            }
            json.append(getWriter().write(key.toString()))
                    .append(":")
                    .append(getWriter().write(entry.getValue()));
        }
        json.append("}");
        return json.toString();
    }
}
