package org.seat.web.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean ret1 = request.getSession().getAttribute("adminName") != null;
        boolean ret2 = request.getSession().getAttribute("uname") != null;
        return ret1 || ret2;
    }
}
