package com.mustache.bbs4.service;

import com.mustache.bbs4.domain.Article;
import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.ArticleResponse;
import com.mustache.bbs4.domain.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleResponse getArticle(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id); // Entity
        Article article = optArticle.get();
        ArticleResponse articleResponse = Article.of(article);

        return articleResponse;
    }

}
