package com.tericcabrel.passify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

// TODO Will be populated by fetching a external API
@Entity
@Table(name = "countries")
public class Country extends Model {

    @Column(length = 100, nullable = false, unique = true)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(length = 5, nullable = false, unique = true)
    @NotBlank(message = "Code is required")
    @Size(min = 2, max = 5, message = "Must be greater than 1 and lower than 6 characters")
    private String code;

    @Column(nullable = false, name = "indicator")
    @Min(value = 1, message = "Must be greater than 1")
    @Max(value = 999, message = "Must be lower than 1000")
    private int phoneIndicator;

    @OneToMany(mappedBy = "country")
    private Set<CountryEvaluation> countryEvaluations = new HashSet<>();

    public Country() {

    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public int getPhoneIndicator() {
        return phoneIndicator;
    }

    public Country setPhoneIndicator(int phoneIndicator) {
        this.phoneIndicator = phoneIndicator;
        return this;
    }

    public Set<CountryEvaluation> getCountryEvaluations() {
        return countryEvaluations;
    }

    public Country setCountryEvaluations(Set<CountryEvaluation> countryEvaluations) {
        this.countryEvaluations = countryEvaluations;
        return this;
    }
}
