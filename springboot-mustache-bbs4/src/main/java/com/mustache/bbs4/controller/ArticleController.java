package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.Article;
import com.mustache.bbs4.domain.dto.ArticleDto;
import com.mustache.bbs4.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String creatPage() {
        return "articles/new";
    }

    @GetMapping("/{id}")
    public String showSingle(@PathVariable Long id, Model model ){
        Optional<Article> optArticle = articleRepository.findById(id);

        if(optArticle.isEmpty() == false) {
            model.addAttribute("article", optArticle.get());
            return "articles/show";
        } else {
            return "articles/error";
        }

    }
    @GetMapping("/{id}/edit")
    public String delete(@PathVariable Long id, ArticleDto articleDto, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if(optArticle.isEmpty() == false) {
            model.addAttribute("article", optArticle.get());
            return "articles/edit";
        } else {
            return "articles/error";
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        articleRepository.deleteById(id);
        //model.addAttribute("message", String.format("id : %d가 지워졌습니다.", id));
        return "redirect:/articles/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/list";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, ArticleDto articleDto, Model model) {
        //.save()를 할 때 id가 있다면 insert대신 update가 실행. duplicated entry error x
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", article);
        return String.format("redirect:/articles/%d", article.getId());
    }

    @PostMapping("/post")
    public String post(ArticleDto articleDto) {
        log.info(articleDto.getTitle(), articleDto.getContent());
        Article postArticle = articleRepository.save(articleDto.toEntity());
        return String.format("redirect:/articles/%d", postArticle.getId());
    }

}
