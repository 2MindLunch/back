package com.simsim.solution.recomend.service.classification;


import com.simsim.solution.recomend.entity.classification.FoodClassification;
import com.simsim.solution.recomend.repository.jpql.classification.FoodClassificationRepository;
import com.simsim.solution.recomend.repository.querydsl.classification.FoodClassificationQuerydsl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
@Transactional
@RequiredArgsConstructor
public class FoodClassificationService {

    private final FoodClassificationRepository foodClassificationRepository;
    private final FoodClassificationQuerydsl foodClassificationQuerydsl;

    public void save(FoodClassification foodClassification){
        foodClassificationRepository.save(foodClassification);
    }

    public void saveAll(List<FoodClassification> foodClassifications){
        foodClassificationRepository.saveAll(foodClassifications);
    }

    @Transactional(readOnly = true)
    public FoodClassification.Pk recommendFoodRandomly(){
        List<FoodClassification.Pk> pks = foodClassificationQuerydsl.findAllFood();
        int max = pks.size() - 1;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, max);
        return pks.get(randomIndex);
    }
}
