package com.herenpeng.json.content;

import java.io.Serializable;

/**
 * @author herenpeng
 * @since 2021-07-02 23:31
 */
public enum DatePatternEnums implements Serializable {

    /**
     * 默认的日期格式化格式
     */
    DEFAULT("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式化格式
     */
    private final String value;

    public String getValue() {
        return value;
    }

    DatePatternEnums(String value) {
        this.value = value;
    }
}
