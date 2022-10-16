package com.simsim.solution.recomend.service.classification;

import com.simsim.solution.recomend.entity.classification.FoodClassification;
import com.simsim.solution.recomend.type.classification.foodclassification.FoodMajorClass;
import com.simsim.solution.recomend.type.classification.foodclassification.FoodNation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class FoodClassificationServiceTest {

    @Autowired
    private FoodClassificationService foodClassificationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void saveFoodClassification(){
        List<FoodClassification> foodClassifications = new ArrayList<>();

        FoodClassification.Pk pk1 = FoodClassification.Pk
                .builder()
                .nation(FoodNation.KOREA)
                .majorClass(FoodMajorClass.RICE)
                .food("비빔밥")
                .build();

        FoodClassification foodClassification1 = FoodClassification.builder().pk(pk1).build();
        foodClassifications.add(foodClassification1);

        FoodClassification.Pk pk2 = FoodClassification.Pk
                .builder()
                .nation(FoodNation.JAPAN)
                .majorClass(FoodMajorClass.RICE)
                .food("초밥")
                .build();

        FoodClassification foodClassification2 = FoodClassification.builder().pk(pk2).build();
        foodClassifications.add(foodClassification2);

        FoodClassification.Pk pk3 = FoodClassification.Pk
                .builder()
                .nation(FoodNation.CHINA)
                .majorClass(FoodMajorClass.NOODLE)
                .food("짜장면")
                .build();

        FoodClassification foodClassification3 = FoodClassification.builder().pk(pk3).build();
        foodClassifications.add(foodClassification3);

        FoodClassification.Pk pk4 = FoodClassification.Pk
                .builder()
                .nation(FoodNation.WESTERN)
                .majorClass(FoodMajorClass.NOODLE)
                .food("스파게티")
                .build();

        FoodClassification foodClassification4 = FoodClassification.builder().pk(pk4).build();
        foodClassifications.add(foodClassification4);

        foodClassificationService.saveAll(foodClassifications);

    }

    @Test
    public void recommendRandomly() throws Exception {
        mockMvc.perform(get("/food/recommend/random"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("random-recommend",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("nation").description("국식 ex) 한식,중식,일식,양식"),
                                fieldWithPath("majorClass").description("대분류 ex) 밥류,면류,국류"),
                                fieldWithPath("food").description("음식명"))));

    }




}
