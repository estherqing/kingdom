package com.esther.code.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liudongyang
 */
public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String START_DATE = "2018-01-01";
    public static final Long START_STAMP = 1514736000000L;

    /**
     * 获取指定日期最早的Timestamp的字符串
     *
     * @param dateStr
     * @return
     */
    public static String getDateBeginTimestamp(String dateStr) {
        Date date = parseDate(dateStr);
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return String.valueOf(calendar.getTimeInMillis());
    }

    /**
     * 获取指定日期最晚的Timestamp的字符串
     *
     * @param dateStr
     * @return
     */
    public static String getDateEndTimestamp(String dateStr) {
        Date date = parseDate(dateStr);
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return String.valueOf(calendar.getTimeInMillis());
    }

    /**
     * String转化为Date
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = getSimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getDefault());
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("日期转换出错： " + dateStr, e);
            return null;
        }
    }

    /**
     * String转化为Date yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     */
    public static Date parseDateTime(String dateStr) {
        SimpleDateFormat sdf = getSimpleDateFormat(DATE_TIME_FORMAT);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("日期转换出错： " + dateStr, e);
            return null;
        }
    }

    public static String formatDate(Date dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(dateStr);
    }


    private static SimpleDateFormat getSimpleDateFormat(String dateFormat) {
        return new SimpleDateFormat(dateFormat);
    }

    /**
     * 格式化日期字符串，确保是 yyyy-MM-dd 形式的，比如 2018-1-1 要变成 2018-01-01
     *
     * @param dateStr
     * @return
     */
    public static String formatDateString(String dateStr) {
        if (StringUtils.length(dateStr) == 10) {
            return dateStr;
        }

        SimpleDateFormat sdf = getSimpleDateFormat(DATE_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("日期转换出错： " + dateStr, e);
            return null;
        }

        return sdf.format(date);
    }

    /**
     * 根据周日获取上一个周一
     */
    public static String getStartDayOfWeek(String sunday) {
        Date date = parseDate(sunday);
        if (date == null) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, -6);
            return DateUtils.formatDate(calendar.getTime());
        } catch (Exception e) {
            logger.error("日期转换出错： " + sunday, e);
            return null;
        }
    }

    /**
     * 返回今天是星期几
     */
    public static int getDayOfWeek(String dateStr) {
        Date date = parseDate(dateStr);
        if (date == null) {
            return -1;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.DAY_OF_WEEK);
        } catch (Exception e) {
            logger.error("日期转换出错： " + dateStr, e);
            return -1;
        }
    }

    /**
     * 判断两个日期相差的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int dateIntervalNum(Date startDate, Date endDate) {
        int days = (int) ((endDate.getTime() - startDate.getTime()) / ExerciseConstants.DAY_MILLISECOND);
        return days;
    }

    /**
     * 判断两个日期相差的天数
     *
     * @return
     */
    public static String getDateBack(String curDate, int back) {
        Date date = parseDate(curDate);
        if (date == null) {
            return null;
        }
        try {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-back);
        return DateUtils.formatDate(calendar.getTime());
        } catch (Exception e) {
            logger.error("日期转换出错： " + curDate, e);
            return null;
        }
    }

    /**
     * 获取当前以及前6天的日期
     *
     * @return
     */
    public static List<String> getWeekDateList(String curDate) {
        Date date = parseDate(curDate);
        if (date == null) {
            return null;
        }
        List<String> dateList = new ArrayList<>();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            for(int i=0;i<7;i++) {
                dateList.add(DateUtils.formatDate(calendar.getTime()));
                calendar.add(Calendar.DATE, -1);
            }
            return dateList;
        } catch (Exception e) {
            logger.error("日期转换出错： " + curDate, e);
            return null;
        }
    }

    public static String getTomorrowDate() {
        SimpleDateFormat sdf = getSimpleDateFormat(DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 返回(当天+偏移量)0点的时间戳
     * @param i 偏移量，-1则返回昨天0点的时间戳
     * @return
     */
    public static Long getTimestampScale(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.add(Calendar.DATE, i);
        return calendar.getTime().getTime();
    }

    public static String getTodayDateStr(){
       return getSimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    public static String getNowTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }


    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到毫秒的时间戳字符串
     * @param format 需要转换的格式 默认yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if(seconds == null || seconds.isEmpty()){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 获取今天最早时间戳， 0点0分0秒
     */
    public static Long getTodayFirstTimestamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前时间一周前的时间戳
     */
    public static Long getAWeekAgoTimestamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 6);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前时间30天前的时间戳
     */
    public static Long getAMonthAgoTimestamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 29);
        return calendar.getTimeInMillis();
    }

    public static Integer getHourFromStamp(Long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定时间戳所在月份开始的时间戳
     * @param timestamp 时间戳
     * @return
     */
    public static Long getMonthBegin(String timestamp) {
        String dateStr = timeStamp2Date(timestamp, null);
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(dateStr));

        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis();
    }

    /**
     * 获取指定时间戳所在月份结束的时间戳
     * @param timestamp 时间戳
     * @return
     */
    public static Long getMonthEnd(String timestamp) {
        String dateStr = timeStamp2Date(timestamp, null);
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(dateStr));

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND,59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTimeInMillis();
    }

    public static void main(String[] args){
    }
}
