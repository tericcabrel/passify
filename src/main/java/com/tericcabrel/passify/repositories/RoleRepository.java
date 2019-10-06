package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    public Role findByName(String name);
}
