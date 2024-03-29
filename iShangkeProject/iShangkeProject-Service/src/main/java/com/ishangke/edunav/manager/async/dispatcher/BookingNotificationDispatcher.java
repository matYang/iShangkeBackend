package com.ishangke.edunav.manager.async.dispatcher;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import com.ishangke.edunav.common.enums.BookingEnums;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

public class BookingNotificationDispatcher {
    
    private static interface Command{
        Future<Boolean> sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course);
    }
    
    private static final Map<BookingEnums.Status, Command> map;
    
    static {
        Map<BookingEnums.Status, Command> tempMap = new HashMap<BookingEnums.Status, Command>();
        tempMap.put(BookingEnums.Status.OFFLINEBOOKED, new Command() {
            @Override
            public synchronized Future<Boolean> sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course) {
                return SMSDispatcher.sendBookingAwaitingSMS(booking, course);
            }
        });
//        tempMap.put(BookingEnums.Status.OFFLINEREJECTED, new Command() {
//            @Override
//            public synchronized Future<Boolean> sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course) {
//                if (comment == null) {
//                    comment = "课已订满";
//                }
//                return SMSDispatcher.sendBookingFailedSMS(booking, comment, course);
//            }
//        });
        tempMap.put(BookingEnums.Status.OFFLINECONFIRMED, new Command() {
            @Override
            public synchronized Future<Boolean> sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course) {
                return SMSDispatcher.sendBookingConfirmedSMS(booking, course);
            }
        });
        map = Collections.unmodifiableMap(tempMap);
    }
    

    public static final Future<Boolean> sendNotification(BookingEnums.Status status, BookingEntityExt booking, CourseEntityExt course) {
        Command cmd = map.get(status);
        if (cmd != null) {
            String comment = null;
            if (booking.getNote() != null && !"".equals(booking.getNote())) {
                comment = booking.getNote();
            }
            return cmd.sendNotification(booking, comment, course);
        }
        return null;
        
    }

}
