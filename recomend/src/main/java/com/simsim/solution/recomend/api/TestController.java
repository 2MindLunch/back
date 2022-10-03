package com.simsim.solution.recomend.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public void test(@RequestBody List<Long> testList){
        testList.stream().forEach(x->log.info(x.toString()));
    }
}
