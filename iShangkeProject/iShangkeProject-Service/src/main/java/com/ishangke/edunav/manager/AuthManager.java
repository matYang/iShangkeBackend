package com.ishangke.edunav.manager;

import java.util.concurrent.Future;

public interface AuthManager {

    /**
     * used for access control
     */
    public boolean isAbleToLogin(final String identifier);

    public Future<Boolean> fail(final String identifier);

    public Future<Boolean> success(final String identifier);

    /**
     * used for account authentication
     */
    public boolean validateAuthSession(final int identifier, final String authCode);

    public String openAuthSession(final int identifier);

    public void closeAuthSession(final int identifier, final String authCode);
    
    public Future<Boolean> closeAllAuthSession(final int identifier);

    /**
     * used for cell verification
     */
    public boolean validateCellVerificationSession(final String cell, final String authCode);

    public String openCellVerificationSession(final String cell);
    
    public Future<Boolean> closeCellVerificationSession(final String identifier);

    /**
     * used for forget password
     */
    public boolean validateForgetPasswordSession(final String identifier, final String authCode);

    public String openForgetPasswordSession(final String identifier);
    
    public Future<Boolean> closeForgetPasswordSession(final String identifier);

    

}
