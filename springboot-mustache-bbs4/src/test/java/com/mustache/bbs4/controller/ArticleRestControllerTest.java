package com.mustache.bbs4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.bbs4.domain.dto.ArticleAddRequest;
import com.mustache.bbs4.domain.dto.ArticleAddResponse;
import com.mustache.bbs4.domain.dto.ArticleDto;
import com.mustache.bbs4.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("1개의 id 정보가 잘 나오는지")
    void getArticle() throws Exception {
        ArticleDto articleDto = ArticleDto.builder()
                .id(1L)
                .title("아아아")
                .content("아")
                .build();

        given(articleService.getArticle(1L))
                .willReturn(articleDto);


        Long articleId = 1L;
        String url = String.format("/api/v1/articles/%d", articleId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").value("아"))
                .andDo(print()); // http request, response내역을 출력 해라

        verify(articleService).getArticle(articleId);
    }

    @Test
    @DisplayName("글 등록이 잘 되는지")
    void add () throws Exception {
        ArticleAddRequest dto = new ArticleAddRequest("제목입니다","내용입니다");

        given(articleService.add(any()))
                .willReturn(new ArticleAddResponse(1L, dto.getTitle(), dto.getContent()));

        mockMvc.perform(post("/api/v1/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목입니다"))
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).add(any());
    }

}