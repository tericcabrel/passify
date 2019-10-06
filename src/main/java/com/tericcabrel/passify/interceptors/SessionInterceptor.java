package com.tericcabrel.passify.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tericcabrel.passify.configs.AppConfig;
import com.tericcabrel.passify.models.User;
import com.tericcabrel.passify.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor
{
    private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

    private AppConfig appConfig;

    private UserRepository userRepository;

    public SessionInterceptor(AppConfig appConfig, UserRepository userRepository) {
        this.appConfig = appConfig;
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        String appName = (String) session.getAttribute("app_name");

        if (appName == null) {
            session.setAttribute("app_name", appConfig.getAppname());
        }

        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (username != null && !username.equals("anonymousUser")) {
            String userName = (String) session.getAttribute("user_name");
            if (userName != null) {
                return true;
            }

            User user = this.userRepository.findByEmail(username);
            if (user != null) {
                session.setAttribute("user_name", user.getName());
                logger.info(user.getName());
                session.setAttribute("user_avatar", user.getAvatar());
            } else {
                logger.info("Current user not found in the database");
            }

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
    }
}
