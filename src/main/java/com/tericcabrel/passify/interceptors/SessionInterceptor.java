package com.tericcabrel.passify.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tericcabrel.passify.configs.AppConfig;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor
{
    private AppConfig appConfig;

    public SessionInterceptor(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String appName = (String) request.getSession().getAttribute("app_name");

        if (appName == null) {
            request.getSession().setAttribute("app_name", appConfig.getAppname());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {

        System.out.println("Inside after completion");
    }
}
