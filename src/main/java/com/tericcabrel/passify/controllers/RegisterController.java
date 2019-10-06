package com.tericcabrel.passify.controllers;

import javax.validation.Valid;

import com.tericcabrel.passify.dtos.UserRegistrationDto;
import com.tericcabrel.passify.models.User;
import com.tericcabrel.passify.models.enums.UserGender;
import com.tericcabrel.passify.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        userRegistrationDto.setMark(50)
                .setTimezone("UTC")
                .setPassCode(1234)
                .setCity("Douala");

        return userRegistrationDto;
    }

    @GetMapping
    public String showRegisterForm(Model model) {
        return "auth/register";
    }

    @PostMapping
    public String registerUser(
            @ModelAttribute("user") @Valid UserRegistrationDto userDto,
            BindingResult result
    ) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "auth/register";
        }
        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("lat", 4.0897674);
        coordinates.put("lon", 9.5612345);

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));
                userDto.setPhone("693642889")
                .setGender(UserGender.MALE)
                .setBirthDate(LocalDate.parse("1995-03-14"))
                .setCredit(0)
                .setAvatar(null)
                .setAboutMe("I'm programmer and i have no life !")
                .setExpireDate(zonedDateTimeNow.plusYears(1L))
                .setCoordinates(coordinates);


        userService.save(userDto);

        // TODO Send confirmation email

        return "redirect:/register?success";
    }
}
