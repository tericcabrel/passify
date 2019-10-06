package com.tericcabrel.passify.dtos;

import com.tericcabrel.passify.constraints.FieldMatch;
import com.tericcabrel.passify.converters.UserCoordinateConverter;
import com.tericcabrel.passify.models.Country;
import com.tericcabrel.passify.models.enums.UserGender;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Map;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
})
public class UserRegistrationDto {
    @Min(value = 1000, message = "The code must be equal or greater than 1000")
    @Max(value = 9999, message = "The code must be equal or lower than 9999")
    private int passCode;

    @NotBlank(message = "The name is required")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "valid.email.invalid")
    private String email;

    @Size(min = 6, message = "Must be at least 6 characters")
    private String password;

    @Pattern(regexp = "^[0-9]{9}$", message = "Invalid phone number")
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private UserGender gender;

    @Past(message = "The date must be in the pass")
    private LocalDate birthDate;

    @Future(message = "The date must be in the pass")
    private ZonedDateTime expireDate;

    @Positive(message = "Mark must be a positive value")
    private int mark;

    @PositiveOrZero(message = "Mark must be a positive value or equal to 0")
    private int credit;

    private Byte[] avatar;

    @Size(min = 10, max = 250, message = "About Me must be between 10 and 250 characters")
    private String aboutMe;

    @NotBlank(message = "The timezone is required")
    private String timezone;

    private Country country;

    @NotBlank(message = "City is required")
    private String city;

    @Convert(converter = UserCoordinateConverter.class)
    private Map<String, Object> coordinates;

    @AssertTrue(message = "You must check this case")
    private Boolean terms;

    @NotBlank(message = "This field is required")
    private String confirmPassword;

    public int getPassCode() {
        return passCode;
    }

    public UserRegistrationDto setPassCode(int passCode) {
        this.passCode = passCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserRegistrationDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserRegistrationDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserGender getGender() {
        return gender;
    }

    public UserRegistrationDto setGender(UserGender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserRegistrationDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public ZonedDateTime getExpireDate() {
        return expireDate;
    }

    public UserRegistrationDto setExpireDate(ZonedDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public UserRegistrationDto setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public int getCredit() {
        return credit;
    }

    public UserRegistrationDto setCredit(int credit) {
        this.credit = credit;
        return this;
    }

    public Byte[] getAvatar() {
        return avatar;
    }

    public UserRegistrationDto setAvatar(Byte[] avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public UserRegistrationDto setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public UserRegistrationDto setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public UserRegistrationDto setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserRegistrationDto setCity(String city) {
        this.city = city;
        return this;
    }

    public Map<String, Object> getCoordinates() {
        return coordinates;
    }

    public UserRegistrationDto setCoordinates(Map<String, Object> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Boolean getTerms() {
        return terms;
    }

    public UserRegistrationDto setTerms(Boolean terms) {
        this.terms = terms;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "passCode=" + passCode +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", expireDate=" + expireDate +
                ", mark=" + mark +
                ", credit=" + credit +
                ", avatar=" + Arrays.toString(avatar) +
                ", aboutMe='" + aboutMe + '\'' +
                ", timezone='" + timezone + '\'' +
                ", country=" + country +
                ", city='" + city + '\'' +
                ", coordinates=" + coordinates +
                ", terms=" + terms +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
