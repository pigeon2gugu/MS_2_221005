package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.dto.ArticleDto;
import com.mustache.bbs4.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

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

}