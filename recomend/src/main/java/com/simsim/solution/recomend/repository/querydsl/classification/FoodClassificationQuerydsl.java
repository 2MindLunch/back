package com.simsim.solution.recomend.repository.querydsl.classification;

import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.simsim.solution.recomend.entity.classification.QFoodClassification.foodClassification;

import com.simsim.solution.recomend.entity.classification.FoodClassification;
import com.simsim.solution.recomend.repository.jpql.classification.FoodClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class FoodClassificationQuerydsl{
        private final JPAQueryFactory queryFactory;
        private final FoodClassificationRepository foodClassificationRepository;

    public List<FoodClassification.Pk> findAllFood() {
        return queryFactory.select(foodClassification.pk).from(foodClassification).fetch();
    }
}
