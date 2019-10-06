package com.tericcabrel.passify.models;

import com.tericcabrel.passify.converters.CryptoConverter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends Model {
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    @NotBlank(message = "Name is required")
    private String accountNumber;

    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    private String ribCode;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CreditCard> creditCards;

    public BankAccount() {
        creditCards = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public BankAccount setName(String name) {
        this.name = name;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccount setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getRibCode() {
        return ribCode;
    }

    public BankAccount setRibCode(String ribCode) {
        this.ribCode = ribCode;
        return this;
    }

    public User getUser() {
        return user;
    }

    public BankAccount setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public BankAccount setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
        return this;
    }
}
