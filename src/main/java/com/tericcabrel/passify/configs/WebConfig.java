package com.tericcabrel.passify.configs;

import com.tericcabrel.passify.interceptors.SessionInterceptor;
import com.tericcabrel.passify.repositories.UserRepository;
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
    private MessageSource messageSource;

    private UserRepository userRepository;

    public WebConfig(MessageSource messageSource, UserRepository userRepository) {
        this.messageSource = messageSource;
        this.userRepository = userRepository;
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor(userRepository);
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