package com.simsim.solution.recomend.repository.jpql.classification;

import com.simsim.solution.recomend.entity.classification.FoodClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodClassificationRepository extends JpaRepository<FoodClassification,FoodClassification.Pk> {


}
