package com.tericcabrel.passify.services.interfaces;

import com.tericcabrel.passify.dtos.UserRegistrationDto;
import com.tericcabrel.passify.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto userRegistrationDto);
}
