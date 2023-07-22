package com.yin.catsearch.domain.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("랜덤한 고양이 사진을 50개 검색한다.")
    void getRandomImages() throws Exception {
         mockMvc.perform(get("/cats/random50"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.data").exists())
                .andDo(print())
                .andDo(document("get-randomImages",
                        responseFields(
                                fieldWithPath("data.[].id").description("이미지 아이디"),
                                fieldWithPath("data.[].url").description("이미지 url"),
                                fieldWithPath("data.[].name").description("품종 이름")
                        )));
    }

    @Test
    @DisplayName("품종이름으로 고양이 사진을 검색한다.")
    void searchByBreed() throws Exception {
        mockMvc.perform(get("/cats/search").param("q", "Chantilly-Tiffany"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.data").exists())
                .andDo(print())
                .andDo(document("get-searchByBreed",
                        responseFields(
                                fieldWithPath("data.[].id").description("이미지 아이디"),
                                fieldWithPath("data.[].url").description("이미지 url"),
                                fieldWithPath("data.[].name").description("품종 이름")
                        )));
    }

    @Test
    @DisplayName("아이디로 고양이 사진을 검색한다.")
    void searchById() throws Exception {
        mockMvc.perform(get("/cats/{id}", "hj7Oh-SRY"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.data").exists())
                .andDo(print())
                .andDo(document("get-searchById",
                        responseFields(
                                fieldWithPath("data.id").description("이미지 아이디"),
                                fieldWithPath("data.url").description("이미지 url"),
                                fieldWithPath("data.name").description("품종 이름"),
                                fieldWithPath("data.width").description("사진 넓이"),
                                fieldWithPath("data.height").description("사진 높이"),
                                fieldWithPath("data.temperament").description("성격"),
                                fieldWithPath("data.origin").description("출신지")
                        )));
    }
}