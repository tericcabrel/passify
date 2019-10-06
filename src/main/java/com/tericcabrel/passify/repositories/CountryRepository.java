package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
