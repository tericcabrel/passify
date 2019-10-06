package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
