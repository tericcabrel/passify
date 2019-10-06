package com.tericcabrel.passify.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix="passify")
public class PassifyConfig {
    @NotNull
    private String appname;

    public String getAppname() {
        return appname;
    }

    public PassifyConfig setAppname(String appname) {
        this.appname = appname;
        return this;
    }

    @Override
    public String toString() {
        return "PassifyConfig{" +
                "appname='" + appname + '\'' +
                '}';
    }
}
