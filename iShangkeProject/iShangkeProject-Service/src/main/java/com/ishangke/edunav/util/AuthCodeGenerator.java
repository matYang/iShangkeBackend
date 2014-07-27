package com.ishangke.edunav.util;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.ishangke.edunav.common.utilities.DateUtility;

public final class AuthCodeGenerator {
    
    public static final String numerical(int length) {
        String authCode = "";
        //plant a little seed
        Random ran = new Random(DateUtility.getCurTime());
        //generating a single digit at a time
        for (int i = 0; i < length; i++) {
            authCode += ran.nextInt(10);
        }
        
        return authCode;
    }
    
    public static final String alphaNumerical(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

}
