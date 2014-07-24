package com.ishangke.edunav.common.utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateUtility {

    public static final long milisecInDay = 86400000l;
    public static final long milisecInHour = 3600000l;

    public static Calendar getCurTimeInstance() {
        return Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    }

    public static long getCurTime() {
        Calendar c = getCurTimeInstance();
        return c.getTimeInMillis();
    }

    public static Calendar getTimeFromLong(final long mili) {
        if (mili < 0){
            return null;
        }
        Calendar c = getCurTimeInstance();
        c.setTimeInMillis(mili);
        return c;
    }

    // convert sql.date and calendar
    public static String toSQLDateTime(final Calendar c) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(c.getTime());
    }

    public static Calendar DateToCalendar(Date date) {
        if (date == null)
            return null;

        Calendar cal = getCurTimeInstance();
        cal.setTime(date);
        return cal;
    }

    // format the calendar into a string that fits in SMS contents
    public static String smsFormat(final Calendar c) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH:mm");
        // this is not needed as when date does not have time zone info, just
        // placed here to clarify
        sdf.setTimeZone(TimeZone.getTimeZone("asia/shanghai"));

        String dateStr = sdf.format(c.getTime());
        if (dateStr.indexOf("0") == 0) {
            dateStr = dateStr.substring(1, dateStr.length());
        }
        return dateStr;
    }

    // compare if two calendars are on the same day, ignore hh mm ss
    public static int compareday(final Calendar cal1, final Calendar cal2) {
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) {
            return -1;
        } else if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR)) {
            return -1;
        } else if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
            return 0;
        } else {
            return 1;
        }

    }

    public static String formatReadable(final Calendar c) {
        // do not change the original calendar, make a copy
        Calendar cur = getCurTimeInstance();
        cur.setTimeInMillis(c.getTimeInMillis());
        cur.setTimeZone(TimeZone.getTimeZone("asia/shanghai"));

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        String dateStr = sdf.format(cur.getTime());
        if (dateStr.indexOf("0") == 0) {
            dateStr = dateStr.substring(1, dateStr.length());
        }
        return dateStr;
    }

    public static String formatReadableDate(final Calendar c) {
        // do not change the original calendar, make a copy
        Calendar cur = getCurTimeInstance();
        cur.setTimeInMillis(c.getTimeInMillis());
        cur.setTimeZone(TimeZone.getTimeZone("asia/shanghai"));

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        String dateStr = sdf.format(cur.getTime());
        if (dateStr.indexOf("0") == 0) {
            dateStr = dateStr.substring(1, dateStr.length());
        }
        return dateStr;
    }

}
