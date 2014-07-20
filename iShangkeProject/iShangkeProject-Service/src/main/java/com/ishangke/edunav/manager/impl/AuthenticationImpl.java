package com.ishangke.edunav.manager.impl;

import com.ishangke.edunav.manager.AuthenticationManager;

public class AuthenticationImpl implements AuthenticationManager {

    @Override
    public boolean isAbleToLogin(String identifier) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void fail(String identifier) {
        // TODO Auto-generated method stub

    }

    @Override
    public void success(String identifier) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean validateAuthSession(int identifier, String authCode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String openAuthSession(int identifier) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean closeAuthSession(int identifier, String authCode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validateCellSession(String cell, String authCode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String openCellSession(String cell) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean closeCellSession(String cell) {
        // TODO Auto-generated method stub
        return false;
    }

}
