package com.mustache.bbs2.controller;

import com.mustache.bbs2.domain.Article;
import com.mustache.bbs2.domain.dto.ArticleDto;
import com.mustache.bbs2.domain.repository.ArticleRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j //log기능 추가
public class ArticleController {

    //Spring이 ArticleRepository구현체 (ArticleDao라고 보면 됨)를 DI (interface 아님)
    //기능 : findAll(), findById(), save(), deleteAll() ... 등이 자동으로 만들어 짐.
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping("/new")
    public String createPage() {
        return "articles/new"; //articles diractory의 new.mustache로
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if (!optArticle.isEmpty()) {
            //Optinal.get() -> Article
            model.addAttribute("article", optArticle.get());
            return "articles/show";
        } else {
            return "articles/error";
        }

    }
    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle(), articleDto.getContent());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId:{}", savedArticle.getId());
        return "";
    }
}
