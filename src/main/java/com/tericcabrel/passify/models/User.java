package com.tericcabrel.passify.models;

import com.tericcabrel.passify.converters.UserCoordinateConverter;
import com.tericcabrel.passify.models.enums.UserGender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "users")
public class User extends Model {
    @Column(name = "pass_code", nullable = false)
    private int passCode;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, unique = true, length = 255)
    private String password;

    @Column(nullable = false, length = 30)
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private UserGender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "expire_date", nullable = false)
    private ZonedDateTime expireDate;

    @Column()
    private int mark;

    @Column()
    private int credit;

    @Column()
    @Lob
    private Byte[] avatar;

    @Column(name = "about_me", nullable = false, length = 250)
    private String aboutMe;

    @Column(nullable = false)
    private String timezone;

    @OneToOne(fetch = FetchType.EAGER)
    private Country country;

    @Column(nullable = false, length = 100)
    private String city;

    @Convert(converter = UserCoordinateConverter.class)
    private Map<String, Object> coordinates;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<AppAccount> appAccounts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "user")
    private Set<CountryEvaluation> countryEvaluations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<NoteGroup> noteGroups;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<BankAccount> bankAccounts;

    @ManyToMany()
    @JoinTable(name = "users_topics", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<Role> roles;

    public User() {
        appAccounts = new HashSet<>();
        contacts = new HashSet<>();
        noteGroups = new HashSet<>();
        bankAccounts = new HashSet<>();
        topics = new HashSet<>();
    }

    public int getPassCode() {
        return passCode;
    }

    public User setPassCode(int passCode) {
        this.passCode = passCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserGender getGender() {
        return gender;
    }

    public User setGender(UserGender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public ZonedDateTime getExpireDate() {
        return expireDate;
    }

    public User setExpireDate(ZonedDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public User setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public int getCredit() {
        return credit;
    }

    public User setCredit(int credit) {
        this.credit = credit;
        return this;
    }

    public Byte[] getAvatar() {
        return avatar;
    }

    public User setAvatar(Byte[] avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public User setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public User setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public User setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public Map<String, Object> getCoordinates() {
        return coordinates;
    }

    public User setCoordinates(Map<String, Object> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Set<AppAccount> getAppAccounts() {
        return appAccounts;
    }

    public User setAppAccounts(Set<AppAccount> appAccounts) {
        this.appAccounts = appAccounts;
        return this;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public User setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    public Set<CountryEvaluation> getCountryEvaluations() {
        return countryEvaluations;
    }

    public User setCountryEvaluations(Set<CountryEvaluation> countryEvaluations) {
        this.countryEvaluations = countryEvaluations;
        return this;
    }

    public Set<NoteGroup> getNoteGroups() {
        return noteGroups;
    }

    public User setNoteGroups(Set<NoteGroup> noteGroups) {
        this.noteGroups = noteGroups;
        return this;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public User setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
        return this;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public User setTopics(Set<Topic> topics) {
        this.topics = topics;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
