package com.ours.common.util;

import java.util.Date;

/**
 * Created by fish on 2018/7/26.
 */
public class DateUtil {

    /**
     * 默认短日期格式
     * yyyy-MM-dd
     */
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 订单号前缀 yyyyMMddHHmmss
     */
    public static final String DATETIME_ORDER_FORMAT = "yyyyMMddHHmmss";
    /**
     * 默认日期时间格式
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认时间格式
     * HH:mm:ss
     */
    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";
    /**
     * 默认日期短格式
     * yyyyMMdd
     */
    public static final String DATE_DEFAULT_SHORT_FORMAT = "yyyyMMdd";


    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

}
