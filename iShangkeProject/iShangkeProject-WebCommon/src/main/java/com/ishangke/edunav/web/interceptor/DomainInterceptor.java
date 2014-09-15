package com.ishangke.edunav.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DomainInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DomainInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if(request.getHeader("referer") == null || !request.getHeader("referer").contains("ishangke.cn")){
            System.out.println("url:"+request.getHeader("referer"));
            response.getWriter().println("sorry~ you can not call api directly~");
            LOGGER.warn(String.format("[Domain Filer]some one want to call our api"));
            return false;
        }else{
            return true;
        }
    }
}
