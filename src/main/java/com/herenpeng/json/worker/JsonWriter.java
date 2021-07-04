package com.herenpeng.json.worker;

import com.herenpeng.json.core.JsonSerializable;

/**
 * @author herenpeng
 * @since 2021-07-03 22:28
 */
public class JsonWriter {

    public static final JsonWorker worker = new JsonWorker();

    public String write(Object object) {
        JsonSerializable jsonSerializable = worker.getJsonSerializable(object);
        return jsonSerializable.write(object);
    }

}
