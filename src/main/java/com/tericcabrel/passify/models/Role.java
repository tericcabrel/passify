package com.tericcabrel.passify.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role extends Model {
    @Column(nullable = false, unique = true)
    @NotBlank(message = "The name is required")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;

        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Role setUsers(HashSet<User> users) {
        this.users = users;

        return this;
    }
}
