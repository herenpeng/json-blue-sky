package com.herenpeng.json.util;

import com.herenpeng.json.content.DatePatternEnums;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author herenpeng
 * @since 2021-07-02 23:26
 */
public class DateUtils {

    /**
     * 格式化日期，默认使用 yyyy-MM-dd HH:mm:ss 格式化日期
     *
     * @param date 日期
     * @return 格式化日期字符串
     */
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePatternEnums.DEFAULT.getValue());
        return sdf.format(date);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
