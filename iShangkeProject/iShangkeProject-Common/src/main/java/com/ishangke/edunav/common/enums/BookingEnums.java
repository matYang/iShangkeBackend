package com.ishangke.edunav.common.enums;

public class BookingEnums {
    public static enum Status implements EnumInterface {
        OFFLINEBOOKED(0), OFFLINEREJECTED(1), OFFLINECANCELLED(2), OFFLINECONFIRMED(3), OFFLINEDELAYED(4), OFFLINENOSHOW(5), OFFLINEREGISTERED(6), OFFLINEPAYED(7), OFFLINESCHOOLSTARTED(8), OFFLINEQUITED(
                9), OFFLINEENROLLED(10), ONLINEPENDINGPAYMENT(11), ONLINECANCELLED(12), ONLINEPAYED(13), ONLINEPENDINGREFUND(14), ONLINEREFUNDED(15), ONLINEPARTNERCONFIRMED(16), ONLINESCHOOLSTARTED(
                17), ONLINEENROLLED(18), ONLINECASHBACKED(19), ONLINEPAYMENTEXPIRED(20), ONLINEPAYMENFAILED(21), OFFLINENOPAYED(23), OFFLINECASHBACKED(24);
        //ONLINEPAYMENTSUCCEEDED(22),这个根本用不到
        public int code;

        @Override
        public int getCode() {
            return code;
        }

        private Status(int code) {
            this.code = code;
        }

        private final static Status[] map = Status.values();

        public static Status fromInt(int n) {
            return map[n];
        }
    }
}
