package com.ishangke.edunav.common.enums;


public class CoursePromotionEnums {
    public static enum Status implements EnumInterface {
        PENDING(0), CANCELLED(1), ONGOING(2), FINISHED(3);
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
