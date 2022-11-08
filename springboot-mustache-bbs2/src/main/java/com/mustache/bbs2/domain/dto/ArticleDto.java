package com.mustache.bbs2.domain.dto;

import com.mustache.bbs2.domain.Article;
import lombok.Getter;

@Getter
public class ArticleDto {
    private String title;

    public ArticleDto(String title) {
        this.title = title;
    }

    public Article toEntity() {
        return new Article(this.title);
    }
}
