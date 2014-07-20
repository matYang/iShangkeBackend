package com.ishangke.edunav.common.enums;

public class SMSEnums {
    public static enum Event implements EnumInterface {
        USER_CELLVERIFICATION(0), USER_CHANGEPASSWORD(1), USER_FORGETPASSWORD(2), USER_BOOKINGAWAITING(3), USER_BOOKINGCONFIRMED(
                4), USER_BOOKINGFAILED(5), USER_REGISTER(6), USER_INVITEE(7), USER_INVITER(8), USER_INVITERCONSOLIDATION(
                9);
        public int code;

        @Override
        public int getCode() {
            return code;
        }

        private Event(int code) {
            this.code = code;
        }

        private final static Event[] map = Event.values();

        public static Event fromInt(int n) {
            return map[n];
        }
    }
}