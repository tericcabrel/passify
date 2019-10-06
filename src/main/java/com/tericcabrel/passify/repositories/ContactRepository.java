package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
