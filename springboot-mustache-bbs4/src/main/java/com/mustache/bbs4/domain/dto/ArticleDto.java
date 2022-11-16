package com.mustache.bbs4.domain.dto;


import com.mustache.bbs4.domain.Article;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArticleDto {

    private Long id;
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
