package com.tericcabrel.passify.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix="passify")
public class AppConfig {
    @NotNull
    private String appname;

    private String cryptoAlgorithm;

    private String cryptoKey;

    public String getAppname() {
        return appname;
    }

    public AppConfig setAppname(String appname) {
        this.appname = appname;
        return this;
    }

    public String getCryptoAlgorithm() {
        return cryptoAlgorithm;
    }

    public AppConfig setCryptoAlgorithm(String cryptoAlgorithm) {
        this.cryptoAlgorithm = cryptoAlgorithm;
        return this;
    }

    public String getCryptoKey() {
        return cryptoKey;
    }

    public AppConfig setCryptoKey(String cryptoKey) {
        this.cryptoKey = cryptoKey;
        return this;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appname='" + appname + '\'' +
                ", cryptoAlgorithm='" + cryptoAlgorithm + '\'' +
                ", cryptoKey='" + cryptoKey + '\'' +
                '}';
    }
}
