package com.ishangke.edunav.dataaccess.common;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;



public class DateUtility {

    public static String toSQLDateTime(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat(DataaccessConstants.DATEFORMAT);
        return sdf.format(c.getTime());
    }

    public static Calendar DateToCalendar(Date date){ 
        if (date==null)return null;

        Calendar cal = getCurTimeInstance();
        cal.setTime(date);
        return cal;
    }
    
    public static Calendar getCurTimeInstance(){
        return Calendar.getInstance(TimeZone.getTimeZone(DataaccessConstants.TIMEZONE));
    }
}
