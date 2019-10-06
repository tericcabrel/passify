package com.tericcabrel.passify.services;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import com.tericcabrel.passify.dtos.UserRegistrationDto;
import com.tericcabrel.passify.models.Role;
import com.tericcabrel.passify.models.User;
import com.tericcabrel.passify.repositories.RoleRepository;
import com.tericcabrel.passify.repositories.UserRepository;
import com.tericcabrel.passify.services.interfaces.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(
            RoleRepository roleRepository,
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setPassCode(passwordEncoder.encode(String.valueOf(userRegistrationDto.getPassCode())));
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setName(userRegistrationDto.getName());
        user.setPhone(userRegistrationDto.getPhone());
        user.setGender(userRegistrationDto.getGender());
        user.setBirthDate(userRegistrationDto.getBirthDate());
        user.setExpireDate(userRegistrationDto.getExpireDate());
        user.setMark(userRegistrationDto.getMark());
        user.setCredit(userRegistrationDto.getCredit());
        user.setAboutMe(userRegistrationDto.getAboutMe());
        user.setTimezone(userRegistrationDto.getTimezone());
        user.setCity(userRegistrationDto.getCity());
        user.setCoordinates(userRegistrationDto.getCoordinates());

        Role role = roleRepository.findByName("USER");
        user.setRoles(Collections.singletonList(role));

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));
        user.setCreatedAt(zonedDateTimeNow).setUpdatedAt(zonedDateTimeNow);

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection <? extends GrantedAuthority > mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
