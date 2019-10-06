package com.tericcabrel.passify.models;

import com.tericcabrel.passify.constraints.CardExpiration;
import com.tericcabrel.passify.constraints.CardNumber;
import com.tericcabrel.passify.converters.CryptoConverter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends Model {
    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    @CardNumber(value = "VISA", message = "Invalid card number")
    @NotBlank(message = "Number is required")
    private String number;

    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    @CardExpiration(message = "Expiration date must be in the future")
    @Pattern(regexp = "^(0[1-9]|1[0-2])-[0-9]{2}$", message = "Expiration must be in format MM-YY")
    @NotBlank(message = "Name is required")
    private String expire;

    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    @Size(min = 3, max = 3, message = "Must be three digits")
    @NotBlank(message = "Security code is required")
    private String securityCode;

    @Column(nullable = false)
    @Lob
    @Convert(converter = CryptoConverter.class)
    @NotBlank(message = "Password is required")
    private String password;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private BankAccount bankAccount;

    public String getName() {
        return name;
    }

    public CreditCard setName(String name) {
        this.name = name;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public CreditCard setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getExpire() {
        return expire;
    }

    public CreditCard setExpire(String expire) {
        this.expire = expire;
        return this;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public CreditCard setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreditCard setPassword(String password) {
        this.password = password;
        return this;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public CreditCard setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }
}
