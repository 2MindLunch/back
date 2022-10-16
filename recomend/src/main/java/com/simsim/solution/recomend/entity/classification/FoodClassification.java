package com.simsim.solution.recomend.entity.classification;


import com.simsim.solution.recomend.entity.base.DetailBaseEntity;
import com.simsim.solution.recomend.type.classification.foodclassification.FoodMajorClass;
import com.simsim.solution.recomend.type.classification.foodclassification.FoodNation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FOOD_CLASSIFICATION")
public class FoodClassification extends DetailBaseEntity {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {

        @Enumerated(value = EnumType.STRING)
        @Column(name = "nation")
        private FoodNation nation;

        @Enumerated(value = EnumType.STRING)
        @Column(name = "major_classification")
        private FoodMajorClass majorClass;

        @Column(name = "food")
        private String food;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pk pk = (Pk) o;
            return this.nation.equals(pk.nation) &&
                   this.majorClass.equals(pk.majorClass) &&
                   this.food.equals(pk.food);

        }

        @Override
        public int hashCode() {
            return Objects.hash(nation,majorClass,food);
        }
    }
}
