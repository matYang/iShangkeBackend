package com.ishangke.edunav.common.utilities;

import com.ishangke.edunav.common.enums.LoginEnums;

/**
 * @author Matthew
 */
public class LoginDeterminer {
    
    
    public static LoginEnums.IdentifierType exam(final String accountIdentifier){
        if (accountIdentifier == null || accountIdentifier.length() == 0) {
            return LoginEnums.IdentifierType.ERR;
        }
        String phonePattern = "^[0-9]*$";
        String invitationPattern = "^[a-zA-Z0-9]*$";
        
        if(accountIdentifier.matches(phonePattern)){
            return LoginEnums.IdentifierType.PHONE;
        }
        else if (accountIdentifier.matches(invitationPattern)) {
            return LoginEnums.IdentifierType.INVITATIONCODE;
        }
        //do not even think about validating email address with regex.. it's virtually impossible
        //link: http://stackoverflow.com/questions/201323/using-a-regular-expression-to-validate-an-email-address
        else if (accountIdentifier.indexOf("@") > 0) {
            return LoginEnums.IdentifierType.EMAIL;
        }
        
        return LoginEnums.IdentifierType.ERR;
    }
}
