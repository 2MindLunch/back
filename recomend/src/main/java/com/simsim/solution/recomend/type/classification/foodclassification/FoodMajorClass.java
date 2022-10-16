package com.simsim.solution.recomend.type.classification.foodclassification;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.annotate.JsonValue;

@AllArgsConstructor
public enum FoodMajorClass {
    RICE("밥류"),
    NOODLE("면류"),
    SOUP("국류");

    private final String TITLE;

    @JsonValue
    public String title(){
        return TITLE;
    }
}
