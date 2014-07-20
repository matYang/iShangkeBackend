package com.ishangke.edunav.manager;

public interface AuthenticationManager {

    public boolean isAbleToLogin(final String identifier);

    public void fail(final String identifier);

    public void success(final String identifier);

    public boolean validateAuthSession(final int identifier, final String authCode);

    public String openAuthSession(final int identifier);

    public boolean closeAuthSession(final int identifier, final String authCode);

    public boolean validateCellSession(final String cell, final String authCode);

    public String openCellSession(final String cell);

    public boolean closeCellSession(final String cell);
}
