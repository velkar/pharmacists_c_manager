package com.app.retail.pharma.support.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.retail.pharma.support.entities.Recommendation;

@Repository
public interface RecommendationRepo extends CrudRepository<Recommendation, Long>{}
