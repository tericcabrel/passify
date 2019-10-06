package com.tericcabrel.passify.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "countries_evaluations")
public class CountryEvaluation {
    @EmbeddedId
    private CountryEvaluationId id = new CountryEvaluationId();

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("countryId")
    private Country country;

    @Min(value = 0)
    @Max(value = 10)
    private float landscape;

    @Min(value = 0)
    @Max(value = 10)
    private float food;

    @Min(value = 0)
    @Max(value = 10)
    private float population;

    @Min(value = 0)
    @Max(value = 10)
    private float development;

    @Min(value = 0)
    @Max(value = 10)
    private float entertain;

    public CountryEvaluationId getId() {
        return id;
    }

    public CountryEvaluation setId(CountryEvaluationId id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CountryEvaluation setUser(User user) {
        this.user = user;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public CountryEvaluation setCountry(Country country) {
        this.country = country;
        return this;
    }

    public float getLandscape() {
        return landscape;
    }

    public CountryEvaluation setLandscape(float landscape) {
        this.landscape = landscape;
        return this;
    }

    public float getFood() {
        return food;
    }

    public CountryEvaluation setFood(float food) {
        this.food = food;
        return this;
    }

    public float getPopulation() {
        return population;
    }

    public CountryEvaluation setPopulation(float population) {
        this.population = population;
        return this;
    }

    public float getDevelopment() {
        return development;
    }

    public CountryEvaluation setDevelopment(float development) {
        this.development = development;
        return this;
    }

    public float getEntertain() {
        return entertain;
    }

    public CountryEvaluation setEntertain(float entertain) {
        this.entertain = entertain;
        return this;
    }

    @Embeddable
    public static class CountryEvaluationId implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long userId;
        private Long countryId;

        public CountryEvaluationId() {

        }

        public CountryEvaluationId(Long userId, Long countryId) {
            super();
            this.userId = userId;
            this.countryId = countryId;
        }

        public Long getUserId() {
            return userId;
        }

        public CountryEvaluationId setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getCountryId() {
            return countryId;
        }

        public CountryEvaluationId setCountryId(Long countryId) {
            this.countryId = countryId;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CountryEvaluationId that = (CountryEvaluationId) o;
            return Objects.equals(userId, that.userId) &&
                    Objects.equals(countryId, that.countryId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, countryId);
        }
    }

}
