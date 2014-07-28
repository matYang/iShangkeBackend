package com.ishangke.edunav.web.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;
import com.ishangke.edunav.web.common.WebConstants;

/**
 * The intercepter checks permission before calling restful method.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    private static final String SESSION_USER = "user";
    private static final String SESSION_PERMISSIONS = "permissions";
    private static final String ACCESS_DENY_LOG = "Access denied: User=%s, Role=%s, Resource=%s";

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException,ServletException {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String classUri = handlerMethod.getBean().getClass().getAnnotation(RequestMapping.class).value()[0];
            String methodUri = handlerMethod.getMethodAnnotation(RequestMapping.class).value()[0];
            String requestType = handlerMethod.getMethodAnnotation(RequestMapping.class).method()[0].toString();
            String restfulServiceUri = requestType + classUri + methodUri;
            LOGGER.debug(restfulServiceUri);
            request.setAttribute(WebConstants.REQUEST_URL, restfulServiceUri);
        } else {
            DefaultServletHttpRequestHandler handlerMethod = (DefaultServletHttpRequestHandler) handler;
            handlerMethod.handleRequest(request, response);
        }        
        
        return true;
    }

}
