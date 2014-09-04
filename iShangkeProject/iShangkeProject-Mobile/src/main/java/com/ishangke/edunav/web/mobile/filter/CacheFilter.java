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

import com.ishangke.edunav.common.utilities.DateUtility;


/**
 * Allow Cache:  Category, location, circle, school, career  (3  hours)
 * Disallow Cache: verything else, better for debugging
 * @author Matthew
 */
public class CacheFilter implements Filter {
    
    private static final String EXPIRE_CACHE_DATE = "Sat, 01 Jan 2000 00:00:00 GMT";
    private static final String[] CACHE_PARTIAL_URLS = { "/general/category", "/general/category", "/general/location", "/general/circle", "/general/school", "/general/career" };

    private static final long CACHE_AGE_SEC = 60 * 60 * 3;   //3 hours
    private static final long CACHE_AGE_MILI = 60 * 60 * 3 * 1000;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String requestPath = getRequestPath(httpRequest);

        if (!isCacheUrl(requestPath)) {
            // We have a response that shouldn't be cached, add no caching headers.
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setHeader("Cache-Control", "no-cache");
            httpResponse.setHeader("Expires", EXPIRE_CACHE_DATE);
        }
        else {
            //or cache for 3 hours, sounds like a plan
            long now = DateUtility.getCurTime();
            httpResponse.addHeader("Cache-Control", "max-age=" + CACHE_AGE_SEC );
            httpResponse.addHeader("Cache-Control", "must-revalidate");   //optional
            httpResponse.setDateHeader("Last-Modified", now);
            httpResponse.setDateHeader("Expires", now + CACHE_AGE_MILI);
        }

        chain.doFilter(request, response);
    }

    /**
     * Retrieves the request path, which is the requested URL minus the
     * servlet context path.
     * @param request The request object for this request.
     * @return A String containing on the request path.
     */
    private String getRequestPath(HttpServletRequest request) {
        return request.getRequestURI().replaceFirst(request.getContextPath(), "");
    }

    private boolean isCacheUrl(String requestPath) {
        boolean noCache = false;

        for (String url : CACHE_PARTIAL_URLS) {
            if (requestPath.contains(url)) {
                noCache = true;
            }
        }

        return noCache;
    }
    

    @Override
    public void init(FilterConfig filterConfig) {
        //TODO
    }
    
    @Override
    public void destroy() {
        //TODO
    }
    
}
