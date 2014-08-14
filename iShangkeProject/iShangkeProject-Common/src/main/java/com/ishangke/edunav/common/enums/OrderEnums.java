package com.ishangke.edunav.common.enums;

public class OrderEnums {
    public static enum Status implements EnumInterface {
        NAIVE(0), ACCEPTED(1), FAILED(2), CANCELLED(3);
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
