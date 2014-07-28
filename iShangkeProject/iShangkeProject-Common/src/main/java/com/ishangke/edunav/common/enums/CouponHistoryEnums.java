package com.ishangke.edunav.common.enums;


public class CouponHistoryEnums {
    
    public static enum Operation implements EnumInterface{
        INC(0), DEC(1);
        public int code;
        
        @Override
        public int getCode() {
            return code;
        }
        
        private Operation(int code) {
            this.code = code;
        }
        
        private final static Operation[] map = Operation.values();
        
        public static Operation fromInt(int n) {
            return map[n];
        }
    }
    

}
