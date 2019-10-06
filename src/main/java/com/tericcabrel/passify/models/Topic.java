package com.tericcabrel.passify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic extends Model {
    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "The name is required")
    private String name;

    @ManyToMany(mappedBy = "topics")
    private Set<User> users;

    public Topic() {
        users = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Topic setName(String name) {
        this.name = name;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Topic setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
