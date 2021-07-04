package com.herenpeng.json.core;

import com.herenpeng.json.worker.JsonReader;
import com.herenpeng.json.worker.JsonWriter;

import java.util.Collection;
import java.util.Map;

/**
 * @author herenepeng
 * @since 2021-07-02 23:08
 */
public interface JsonSerializable {


    /**
     * 将Json字符串转换为Java对象
     *
     * @param json Json字符串
     * @return Java对象
     */
    // <T> T read(String json);

    /**
     * 将Java对象转换为Json字符串
     *
     * @param object Java对象
     * @return Json字符串
     */
    String write(Object object);

}
