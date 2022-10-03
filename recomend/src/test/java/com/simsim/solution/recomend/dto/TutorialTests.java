package com.simsim.solution.recomend.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class TutorialTests {

    @Test
    void contextLoads() {

        List<TestDtos2> testDtos2 = new ArrayList<>();
        testDtos2.add(new TestDtos2(1,"김영철","yc1"));
        testDtos2.add(new TestDtos2(2,"김지연","yc2"));
        testDtos2.add(new TestDtos2(3,"김또강","yc3"));
        testDtos2.add(new TestDtos2(4,"김다녀","yc4"));
        testDtos2.add(new TestDtos2(5,"기자녀","yc5"));
        testDtos2.add(new TestDtos2(6,"가물","yc6"));
        testDtos2.add(new TestDtos2(7,"치","yc7"));
        List<TestDto> testDtos = new ArrayList<>();
        testDtos.add(new TestDto(1,"kyc1","yc1"));
        testDtos.add(new TestDto(2,"kyc2","yc2"));
        testDtos.add(new TestDto(3,"kyc3","yc3"));
        testDtos.add(new TestDto(4,"kyc4","yc4"));
        testDtos.add(new TestDto(5,"kyc5","yc5"));
        testDtos.add(new TestDto(6,"kyc6","yc6"));
        testDtos.add(new TestDto(7,"kyc7","yc7"));

        testDtos2.stream().forEach(x->testDtos.stream().forEach(y->methods(x,y)));
        Map<String,String> map = new HashMap<>();

    }

    private void methods(TestDtos2 dto2, TestDto dto){
        if(!(dto.getEstimateId()==dto2.getEstimateId())) return;
        String combine = dto2.getName() + dto.getUniqueId() + dto.getTempId();
        log.info(combine);
    }
}
