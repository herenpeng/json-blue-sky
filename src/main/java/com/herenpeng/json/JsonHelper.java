package com.herenpeng.json;

import com.herenpeng.json.core.*;
import com.herenpeng.json.util.ObjectUtils;

/**
 * Json 工具的主类，所有的功能都从这里出发
 *
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public class JsonHelper {

    public String toJson(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            return null;
        }
        JsonSerializable jsonSerializable = JsonSerializable.getJsonSerializable(object);
        return jsonSerializable.write(object);
    }


}
