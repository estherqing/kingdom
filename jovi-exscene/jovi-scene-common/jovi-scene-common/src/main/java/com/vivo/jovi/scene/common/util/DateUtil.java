package com.vivo.jovi.scene.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author huhan
 * @description
 * @date 2019-05-05 9:55
 */
public class DateUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    public static final String DEF_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DEF_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String formatDate(Date date) {
        return format(date, DEF_DATE_FORMAT);
    }

    public static String formatDateTime(Date date) {
        return format(date, DEF_TIME_FORMAT);
    }

    public static String formatNowDate() {
        return format(getNow(), DEF_DATE_FORMAT);
    }

    public static String formatTime(Date date) {
        return format(date, DEF_TIME_FORMAT);
    }

    public static String formatNowTime() {
        return format(getNow(), DEF_TIME_FORMAT);
    }

    public static Date parse(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return null;
    }

    public static Date parseDate(String dateStr) {
        return parse(dateStr, DEF_DATE_FORMAT);
    }

    public static Date parseTime(String dateStr) {
        return parse(dateStr, DEF_TIME_FORMAT);
    }

    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static Date getDateByDays(Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static Date getDateByMonths(Integer months) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    public static Date getDateByMinutes(Integer minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    public static Date getDateBySeconds(Integer seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}
