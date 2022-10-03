package com.simsim.solution.recomend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestDto {

    private int estimateId;
    private String tempId;
    private String uniqueId;

    public boolean isPosession(int estimateId){
            return (this.estimateId == estimateId);
    }


}
