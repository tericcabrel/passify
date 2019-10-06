package com.tericcabrel.passify.bootstrap;

import com.tericcabrel.passify.models.*;
import com.tericcabrel.passify.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
    private RoleRepository roleRepository;

    public Seeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.loadRoles();
    }

    private void loadRoles() {
        String[] roleNames = new String[] { "USER", "ADMIN" };
        for (String roleName: roleNames) {
            Role role = roleRepository.findByName(roleName);
            if (role == null) {
                ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));

                role = new Role();
                role.setName(roleName)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);
                roleRepository.save(role);
            }
        }
    }

    /*private void loadData() {
        User user = new User();
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("lat", 4.0897674);
        coordinates.put("lon", 9.5612345);

        Country country = new Country();
        country.setName("Cameroon")
                .setCode("CM")
                .setPhoneIndicator(237)
                .setCreatedAt(zonedDateTimeNow)
                .setUpdatedAt(zonedDateTimeNow);

        countryRepository.save(country);

        user.setPassCode(Helper.getRandomNumber(1000, 9999))
            .setName("Eric Cabrel")
            .setEmail("tericcabrel@yahoo.com")
            .setPhone("693642889")
            .setGender(UserGender.MALE)
            .setBirthDate(LocalDate.parse("1995-03-14"))
            .setMark(10)
            .setCredit(0)
            .setAvatar(null)
            .setAboutMe("I'm programmer and i have no life !")
            .setExpireDate(zonedDateTimeNow.plusYears(1L))
            .setTimezone("Europe/Paris")
            .setCountry(country)
            .setCity("Douala")
            .setCoordinates(coordinates)
            .setCreatedAt(zonedDateTimeNow)
            .setUpdatedAt(zonedDateTimeNow);

        System.out.println("GMT Time => "+ zonedDateTimeNow.toString());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Insertion !");
            userRepository.save(user);

            AppAccount appAccount = new AppAccount();
            appAccount.setLabel("Facebook")
                        .setLogin("teco")
                        .setPassword("geek")
                        .setUrl("https://facebook.com")
                        .setDescription("A boring social network")
                        .setLogo(null)
                        .setUser(user)
                        .setCreatedAt(zonedDateTimeNow)
                        .setUpdatedAt(zonedDateTimeNow);

            // This works
            user.getAppAccounts().add(appAccount);
            userRepository.save(user);

            // Also work
            // appAccountRepository.save(appAccount);

            Contact contact1 = new Contact();
            contact1.setName("Pavel")
                    .setNumbers(new String[] { "698620217" })
                    .setUser(user)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            Contact contact2 = new Contact();
            contact2.setName("Fapson")
                    .setNumbers(new String[] { "698390153", "678260013" })
                    .setUser(user)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            user.getContacts().add(contact1);
            user.getContacts().add(contact2);

            userRepository.save(user);

            CountryEvaluation countryEvaluation = new CountryEvaluation();
            countryEvaluation.setCountry(country)
                    .setUser(user)
                    .setDevelopment(3.5F)
                    .setEntertain(7F)
                    .setFood(9F)
                    .setLandscape(7.25F)
                    .setPopulation(4.75F);

            country.getCountryEvaluations().add(countryEvaluation);
            user.getCountryEvaluations().add(countryEvaluation);

            countryEvaluationRepository.save(countryEvaluation);

            NoteGroup noteGroup1 = new NoteGroup();
            noteGroup1.setName("Projects")
                    .setUser(user)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            NoteGroup noteGroup2 = new NoteGroup();
            noteGroup2.setName("Work")
                    .setUser(user)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            noteGroupRepository.save(noteGroup1);
            noteGroupRepository.save(noteGroup2);

            Note note1 = new Note();
            note1.setTitle("TravelSafe")
                    .setContent("Travel project with IOT")
                    .setNoteGroup(noteGroup1)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            Note note2 = new Note();
            note2.setTitle("Hyoka")
                    .setContent("A test examination web site")
                    .setNoteGroup(noteGroup1)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            Note note3 = new Note();
            note3.setTitle("Daily Task")
                    .setContent("Integrate the boilerplate")
                    .setNoteGroup(noteGroup2)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            Note note4 = new Note();
            note4.setTitle("Useful")
                    .setContent("How to manage people")
                    .setNoteGroup(noteGroup2)
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);

            noteGroup1.getNotes().add(note1);
            noteGroup1.getNotes().add(note2);

            noteGroup2.getNotes().add(note3);
            noteGroup2.getNotes().add(note4);

            noteGroupRepository.save(noteGroup1);
            noteGroupRepository.save(noteGroup2);

            BankAccount bankAccount = new BankAccount();
            bankAccount.setName("Afriland")
                        .setAccountNumber("05845191051")
                        .setRibCode("SWIFT-05845191051-1005")
                        .setUser(user)
                        .setCreatedAt(zonedDateTimeNow)
                        .setUpdatedAt(zonedDateTimeNow);

            user.getBankAccounts().add(bankAccount);
            userRepository.save(user);


            CreditCard creditCard = new CreditCard();
            creditCard.setName("ERIC CABREL")
                        .setNumber("4012888888881881")
                        .setExpire("11-19")
                        .setSecurityCode("923")
                        .setPassword("1234")
                        .setBankAccount(bankAccount)
                        .setCreatedAt(zonedDateTimeNow)
                        .setUpdatedAt(zonedDateTimeNow);

            ValidatorFactory creditCardFactory = Validation.buildDefaultValidatorFactory();
            Validator creditCardValidator = creditCardFactory.getValidator();

            Set<ConstraintViolation<CreditCard>> creditCardViolations = creditCardValidator.validate(creditCard);

            if (!creditCardViolations.isEmpty()) {
                for (ConstraintViolation<CreditCard> violation : creditCardViolations) {
                    System.out.println("Credit card error : " + violation.getMessage());
                }
            } else {
                System.out.println("Valid Credit card !");
                bankAccount.getCreditCards().add(creditCard);
                bankAccountRepository.save(bankAccount);
            }

            Topic topic = new Topic();
            topic.setName("Programming")
                    .setCreatedAt(zonedDateTimeNow)
                    .setUpdatedAt(zonedDateTimeNow);
            topic.getUsers().add(user);

            topicRepository.save(topic);

            user.getTopics().add(topic);
            userRepository.save(user);

            User u = userRepository.findByEmail(user.getEmail());
            if (u != null) {
                // Convert automatically to server timezone
                System.out.println("Date => " + u.getCreatedAt().toString());

                // Convert to another timezone
                System.out.println("Timezone => " + u.getCreatedAt().withZoneSameInstant(ZoneId.of(user.getTimezone())));

                System.out.println("App account => " + user.getAppAccounts().size());
                System.out.println("User coordinates => " + user.getCoordinates());
                Iterator<Contact> contactIterator = user.getContacts().iterator();
                System.out.println("App account => " + contactIterator.next().getNumbers()[0]);
                System.out.println("App account => " + contactIterator.next().getNumbers()[0]);

                System.out.println("Note group => " + user.getNoteGroups().size());

                System.out.println("Bank account => " + user.getBankAccounts().size());

                Iterator<BankAccount> bankAccountIterator = user.getBankAccounts().iterator();
                Iterator<CreditCard> creditCardIterator = bankAccountIterator.next().getCreditCards().iterator();
                System.out.println("Credit card => " + creditCardIterator.next().getName());

                // Iterator<CreditCard> creditCardIterator = bankAccount.getCreditCards().iterator();
                // System.out.println("Credit card => " + creditCardIterator.next().getName());

                System.out.println("Topic count => " + user.getTopics().size());
            }

            NoteGroup ng = noteGroupRepository.findByName(noteGroup1.getName());
            if (ng != null) {
                System.out.println("Note count => " + ng.getNotes().size());

                for (Note note : ng.getNotes()) {
                    System.out.println("Note  => " + note.getTitle());
                }
            }
        }
    }*/
}
