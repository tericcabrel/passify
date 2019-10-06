package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.AppAccount;
import org.springframework.data.repository.CrudRepository;

public interface AppAccountRepository extends CrudRepository<AppAccount, Long> {

}
