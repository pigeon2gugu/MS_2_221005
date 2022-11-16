package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.dto.ArticleAddRequest;
import com.mustache.bbs4.domain.dto.ArticleAddResponse;
import com.mustache.bbs4.domain.dto.ArticleDto;
import com.mustache.bbs4.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id) { // ResponseEntity도 DTO타입
        ArticleDto articleDto = articleService.getArticle(id); // DTO
        return ResponseEntity.ok().body(articleDto); // Return은 DTO로
    }

    @PostMapping("")
    public ResponseEntity<ArticleAddResponse> addArticle(ArticleAddRequest dto) {
        ArticleAddResponse response = articleService.add(dto);
        return ResponseEntity.ok().body(response);
    }
}
