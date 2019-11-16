package com.tericcabrel.passify.models;

import com.tericcabrel.passify.converters.ContactNumberConverter;
import com.tericcabrel.passify.models.enums.UserGender;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "contacts")
public class Contact extends Model {
    @Column(nullable = false, length = 100)
    @NotBlank(message = "The name is required")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private UserGender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "numbers")
    @Convert(converter = ContactNumberConverter.class)
    @Size(min = 1)
    private String[] numbers;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = true)
    private Country country;

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

    public UserGender getGender() {
        return gender;
    }

    public Contact setGender(UserGender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Contact setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public Contact setNumbers(String[] numbers) {
        this.numbers = numbers;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Contact setCountry(Country country) {
        this.country = country;
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
