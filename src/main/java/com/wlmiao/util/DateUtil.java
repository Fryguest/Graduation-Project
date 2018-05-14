package com.wlmiao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 */
public class DateUtil {

    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
    private final static SimpleDateFormat prefixTimes = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");

    /**
     * 获取yyyyMMddHHmmss格式
     */
    public static String getSdfTimes() {
        return sdfTimes.format(new Date());
    }

    /**
     * 获取yyyy格式
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取yyyy-MM-dd格式
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取yyyyMMdd格式
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss格式
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     * 根据yyyy-MM-dd格式获得日期
     */
    public static Date parseDay(String dateString) throws ParseException {
        return sdfDay.parse(dateString);
    }

    /**
     * 根据yyyyMMdd格式获得日期
     */
    public static Date getDays(String dateString) throws ParseException {
        return sdfDays.parse(dateString);
    }

    /**
     * 根据yyyy-MM-dd HH:mm:ss格式获得日期
     */
    public static Date getTime(String dateString) throws ParseException {
        return sdfTime.parse(dateString);
    }

    public static String getDirFormatTime() {
        return prefixTimes.format(new Date());
    }


}
