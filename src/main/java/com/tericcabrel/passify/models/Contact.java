package com.tericcabrel.passify.models;

import com.tericcabrel.passify.converters.ContactNumberConverter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class Contact extends Model {
    @Column(nullable = false, length = 100)
    @NotBlank(message = "The name is required")
    private String name;

    @Column(name = "numbers")
    @Convert(converter = ContactNumberConverter.class)
    @Size(min = 1)
    private String[] numbers;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    public Contact() {
        numbers = new String[]{};
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public Contact setNumbers(String[] numbers) {
        this.numbers = numbers;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Contact setUser(User user) {
        this.user = user;
        return this;
    }
}
