package com.ishangke.edunav.common.enums;

public class CouponEnums {
    
    public static enum Status implements EnumInterface {
        USABLE(0), EXPIRED(1), INACTIVE(2);
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
    
    public static enum Origin implements EnumInterface{
        REGISTRATION(0), INVITATION(1), ADMIN(2);
        public int code;
        
        @Override
        public int getCode() {
            return code;
        }
        
        private Origin(int code) {
            this.code = code;
        }
        
        private final static Status[] map = Status.values();
        
        public static Status fromInt(int n) {
            return map[n];
        }
    }
}
