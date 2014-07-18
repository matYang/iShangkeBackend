package com.ishangke.edunav.common.enums;

public class SpreadEnums {

    public static enum Status implements EnumInterface {
        naive(0), approved(1), rejected(2), cancelled(3);
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
