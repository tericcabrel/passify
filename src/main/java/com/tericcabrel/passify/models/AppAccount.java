package com.tericcabrel.passify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "app_accounts")
public class AppAccount extends Model {
    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 50, message = "The label length must be between 3 and 50 characters")
    @NotBlank(message = "Label is required")
    private String label;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Login is required")
    private String login;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(length = 255)
    private String url;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String logo;

    @ManyToOne()
    private User user;

    public String getLabel() {
        return label;
    }

    public AppAccount setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public AppAccount setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AppAccount setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AppAccount setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AppAccount setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public AppAccount setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public User getUser() {
        return user;
    }

    public AppAccount setUser(User user) {
        this.user = user;
        return this;
    }
}
