package com.ishangke.edunav.manager.async.dispatcher;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.ishangke.edunav.common.enums.BookingEnums;
import com.ishangke.edunav.commoncontract.model.CommentBookingBo;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

public class BookingNotificationDispatcher {
    
    private static interface Command{
        void sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course);
    }
    
    private static final Map<BookingEnums.Status, Command> map;
    
    static {
        Map<BookingEnums.Status, Command> tempMap = new HashMap<BookingEnums.Status, Command>();
        tempMap.put(BookingEnums.Status.OFFLINEBOOKED, new Command() {
            @Override
            public synchronized void sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course) {
                SMSDispatcher.sendBookingAwaitingSMS(booking, course);
            }
        });
        tempMap.put(BookingEnums.Status.OFFLINEREJECTED, new Command() {
            @Override
            public synchronized void sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course) {
                if (comment == null) {
                    comment = "课已订满";
                }
                SMSDispatcher.sendBookingFailedSMS(booking, comment, course);
            }
        });
        tempMap.put(BookingEnums.Status.OFFLINECONFIRMED, new Command() {
            @Override
            public synchronized void sendNotification(BookingEntityExt booking, String comment, CourseEntityExt course) {
                SMSDispatcher.sendBookingConfirmedSMS(booking, course);
            }
        });
        map = Collections.unmodifiableMap(tempMap);
    }
    
    public static final void sendNotification(BookingEnums.Status status, BookingEntityExt booking, CommentBookingBo commentBookingBo, CourseEntityExt course) {
        Command cmd = map.get(status);
        if (cmd != null) {
            String comment = null;
            if (commentBookingBo != null) {
                comment = commentBookingBo.getComment();
            }
            cmd.sendNotification(booking, comment, course);
        }
    }

}
