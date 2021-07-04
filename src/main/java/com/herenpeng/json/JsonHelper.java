package com.herenpeng.json;

import com.herenpeng.json.util.ObjectUtils;
import com.herenpeng.json.worker.JsonWorker;
import com.herenpeng.json.worker.JsonWriter;

/**
 * Json 工具的主类，所有的功能都从这里出发
 *
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class JsonHelper extends JsonWorker {

    public String toJson(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            return null;
        }
        return getWriter().write(object);
    }


}
