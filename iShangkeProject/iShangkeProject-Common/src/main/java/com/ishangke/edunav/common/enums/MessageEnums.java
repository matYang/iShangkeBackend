package com.ishangke.edunav.common.enums;

public class MessageEnums {
    public static enum Status implements EnumInterface {
        UNREAD(0), READ(1);
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
