package com.ishangke.edunav.dataaccess.common;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;



public class DateUtility {

    public static String toSQLDateTime(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(c.getTime());
    }

    public static Calendar DateToCalendar(Date date){ 
        if (date==null)return null;

        Calendar cal = getCurTimeInstance();
        cal.setTime(date);
        return cal;
    }
    
    public static Calendar getCurTimeInstance(){
        return Calendar.getInstance(TimeZone.getTimeZone("asia/shanghai"));
    }
}
