package com.ishangke.edunav.common.enums;

public class SMSEnums {
    public static enum Event implements EnumInterface {
        USER_CELLVERIFICATION(0), USER_FORGETPASSWORD(1), USER_BOOKINGAWAITING(2), USER_BOOKINGCONFIRMED(3), USER_BOOKINGFAILED(
                4), USER_REGISTER(5), USER_INVITEE(4), USER_INVITER(7), USER_INVITERCONSOLIDATION(8), PANIC(9);
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