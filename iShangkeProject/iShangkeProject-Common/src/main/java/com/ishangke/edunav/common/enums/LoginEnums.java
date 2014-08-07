package com.ishangke.edunav.common.enums;

public class LoginEnums {
    public static enum IdentifierType implements EnumInterface {
        ERR(0), PHONE(1), INVITATIONCODE(2), EMAIL(3);
        public int code;

        @Override
        public int getCode() {
            return code;
        }

        private IdentifierType(int code) {
            this.code = code;
        }

        private final static IdentifierType[] map = IdentifierType.values();

        public static IdentifierType fromInt(int n) {
            return map[n];
        }
    }
}
