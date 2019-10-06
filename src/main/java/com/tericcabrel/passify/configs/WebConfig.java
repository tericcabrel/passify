package com.tericcabrel.passify.configs;

import com.tericcabrel.passify.interceptors.SessionInterceptor;
import com.tericcabrel.passify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Autowired
    private MessageSource messageSource;

    private AppConfig appConfig;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor(appConfig, userRepository);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        // registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("auth/login");
        // registry.addViewController("/home").setViewName("userhome");
        registry.addViewController("/admin/home").setViewName("app/admin/home");
        // registry.addViewController("/403").setViewName("403");
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }
}