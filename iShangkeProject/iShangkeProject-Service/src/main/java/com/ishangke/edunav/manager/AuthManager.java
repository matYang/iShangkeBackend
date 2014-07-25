package com.ishangke.edunav.manager;

import java.util.concurrent.Future;

public interface AuthManager {

    /**
     * used for access control
     */
    boolean isAbleToLogin(final String identifier);

    Future<Boolean> fail(final String identifier);

    Future<Boolean> success(final String identifier);

    /**
     * used for account authentication
     */
    boolean validateAuthSession(final int identifier, final String authCode);

    String openAuthSession(final int identifier);

    void closeAuthSession(final int identifier, final String authCode);

    Future<Boolean> closeAllAuthSession(final int identifier);

    /**
     * used for cell verification
     */
    boolean validateCellVerificationSession(final String cell, final String authCode);

    String openCellVerificationSession(final String cell);

    Future<Boolean> closeCellVerificationSession(final String identifier);

    /**
     * used for forget password
     */
    boolean validateForgetPasswordSession(final int identifier, final String authCode);

    String openForgetPasswordSession(final int  identifier);

    Future<Boolean> closeForgetPasswordSession(final int identifier);
    
    /**
     * 系统管理员拥有最高权限，可以做任何事
     */
    boolean isSystemAdmin(final int userId);
    
    boolean isAdmin(int userId);
    
    String getRole(final int userId);

}
