package com.simsim.solution.recomend.type.classification.foodclassification;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.annotate.JsonValue;

@AllArgsConstructor
public enum FoodNation {
    KOREA("한식"),
    CHINA("중식"),
    JAPAN("일식"),
    WESTERN("양식");

    private final String TITLE;

    @JsonValue
    public String title(){
        return TITLE;
    }
}
