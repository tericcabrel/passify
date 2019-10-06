package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

}
