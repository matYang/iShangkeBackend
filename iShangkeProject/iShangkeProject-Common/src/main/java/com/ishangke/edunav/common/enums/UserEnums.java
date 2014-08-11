package com.ishangke.edunav.common.enums;


public class UserEnums {
    public static enum Gender implements EnumInterface {
        MALE(0), FEMALE(1), UNKNOWN(2);
        public int code;

        @Override
        public int getCode() {
            return code;
        }

        private Gender(int code) {
            this.code = code;
        }

        private final static Gender[] map = Gender.values();

        public static Gender fromInt(int n) {
            return map[n];
        }
    }
}
