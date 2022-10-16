package com.simsim.solution.recomend.api.classification;

import com.simsim.solution.recomend.entity.classification.FoodClassification;
import com.simsim.solution.recomend.service.classification.FoodClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodClassificationController {

    private final FoodClassificationService foodClassificationService;

    @GetMapping("/recommend/random")
    public FoodClassification.Pk recommendFoodRandomly(){
        return foodClassificationService.recommendFoodRandomly();
    }
}
