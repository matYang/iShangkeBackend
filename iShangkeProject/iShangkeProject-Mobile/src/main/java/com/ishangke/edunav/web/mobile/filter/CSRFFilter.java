package com.ishangke.edunav.web.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * NOT READY FOR USE !!
 * 请勿使用！！
 */


/**
 * So we have money related features and CORS, and so probably we should add Cross-Site Request Forgivery preovention
 * this filter assumes that, at the begining of each session, a security token is attached to the session
 * in this way we know that incoming request is coming from an active http session
 * @author uwse
 *
 */
public class CSRFFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session = httpRequest.getSession();
        String sessionToken = (String)session.getAttribute("securityKey");
        String requestToken = httpRequest.getHeader("X-SECURITY-KEY");
        
        if (requestToken == null || requestToken.isEmpty() || !requestToken.equals(sessionToken)) {
            // A valid security token was not provided in the request, return
            // a forbidden response.
            httpResponse.setStatus(403);
            
        } else {
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void destroy() {
        //TODO
    }
    

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }
}
