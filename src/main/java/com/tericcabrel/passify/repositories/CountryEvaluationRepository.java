package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.CountryEvaluation;
import org.springframework.data.repository.CrudRepository;

public interface CountryEvaluationRepository extends CrudRepository<CountryEvaluation, CountryEvaluation.CountryEvaluationId> {

}
