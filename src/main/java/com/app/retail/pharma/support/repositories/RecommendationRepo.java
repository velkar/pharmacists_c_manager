package com.app.retail.pharma.support.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.retail.pharma.support.entities.Recommendation;

@Repository
public interface RecommendationRepo extends CrudRepository<Recommendation, Long>{
	
	public Recommendation getByMedicineName(String medicineName);
	
	public List<Recommendation> getByAilmentName(String ailmentName);
	
}
