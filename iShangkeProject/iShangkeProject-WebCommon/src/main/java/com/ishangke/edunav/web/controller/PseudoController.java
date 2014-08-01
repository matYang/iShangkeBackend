package com.ishangke.edunav.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.ishangke.edunav.common.constant.SessionSetting;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.manager.crypto.SessionCrypto;
import com.ishangke.edunav.web.common.WebConstants;

@Controller
public class PseudoController {
    
    protected String getUrl(HttpServletRequest req) {
        return String.valueOf(req.getAttribute(WebConstants.REQUEST_URL));
    }
    
    protected SessionBo getSession(HttpServletRequest req){
        try {
            SessionBo sessionBo = new SessionBo();
            sessionBo.setId(-1);
            sessionBo.setAccountIdentifier("");
            sessionBo.setAuthCode("");
            
            String sessionString = null;
            
            //check the x-mobile header first
            sessionString = req.getHeader(SessionSetting.HEADER_KEY);
            
            if (sessionString == null) {
                Cookie[] cookies = req.getCookies();
                boolean found = false;
                
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        if (SessionSetting.COOKIE_KEY.equals(cookies[i].getName())) {
                            //if already found and now a duplciate exists, alert immediately
                            //this is important, throwing a checked exception
                            if (found) {
                                throw new RuntimeException("Dulplicate Session Cookie Detected!");
                            }
                            sessionString = cookies[i].getValue();
                            found = true;
                        }
                    }
                }
            }
            if (sessionString != null) {
                //throws exception
                sessionString = SessionCrypto.decrypt(sessionString);

                String[] sStr = sessionString.split(SessionSetting.SEPARATOR);
                sessionBo.setId(Integer.parseInt(sStr[0]));
                sessionBo.setAuthCode(sStr[1]);
            }
            
            return sessionBo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    protected void openSession(SessionBo sessionBo, boolean remember, HttpServletRequest req, HttpServletResponse resp) {
        try {
            String sessionString = sessionBo.getId() + SessionSetting.SEPARATOR + sessionBo.getAuthCode();
            sessionString = SessionCrypto.encrypt(sessionString);
            int maxAge = remember ? SessionSetting.EXPIRE_SEC : -1;
            
            //set the session string in header
            resp.setHeader(SessionSetting.HEADER_KEY, sessionString);
            
            Cookie[] cookies = req.getCookies();
            boolean found = false;
            
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (SessionSetting.COOKIE_KEY.equals(cookies[i].getName())) {
                        cookies[i].setPath("/");
                        cookies[i].setMaxAge(maxAge);
                        cookies[i].setValue(sessionString);
                        found = true;
                    }
                }
            }
            
            if (!found) {
                Cookie cookie = new Cookie(SessionSetting.COOKIE_KEY, sessionString);
                cookie.setPath("/");
                cookie.setMaxAge(maxAge);
                resp.addCookie(cookie);
            }
            
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (SessionSetting.COOKIE_KEY.equals(cookies[i].getName())) {
                        resp.addCookie(cookies[i]);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    //setting the cookie
    protected void closeSession(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (SessionSetting.COOKIE_KEY.equals(cookies[i].getName())) {
                    cookies[i].setValue("");
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    resp.addCookie(cookies[i]);
                }
            }
        }
    }

}
