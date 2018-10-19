package com.shoppingsocieties.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static Long getTimeDifference(Date startTime, Date endTime) {
        return Math.abs(endTime.getTime() -startTime.getTime());
    }

    public static Date getDateFromString(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        return dateFormat.parse(date);
    }

    public static Date getCurrentTime() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        return dateFormat.parse(dateFormat.format(new Date()));
    }
}
