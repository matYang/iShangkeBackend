package com.ishangke.edunav.web.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


/**
 * Allow for corss-site resource sharing
 * Note this still needs to be modified, obviously allow * is probably not the best idea...
 * @author Mattew
 */
@Component
public class CORSFilter implements Filter {
 
    @Override
    public void init(FilterConfig arg0) throws ServletException {}
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletResponse response=(HttpServletResponse) resp;
 
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Headers", "authCode");
        response.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type");
 
        chain.doFilter(req, resp);
    }
 
    @Override
    public void destroy() {}
 
}
