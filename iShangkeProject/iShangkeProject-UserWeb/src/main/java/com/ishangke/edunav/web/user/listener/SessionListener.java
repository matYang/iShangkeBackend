package com.ishangke.edunav.web.user.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
     * .HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent createEvent) {
        System.err.println("====session-create====");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
     * .http.HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent destroyEvent) {
        System.err.println("====session-destroy====");
    }

}
