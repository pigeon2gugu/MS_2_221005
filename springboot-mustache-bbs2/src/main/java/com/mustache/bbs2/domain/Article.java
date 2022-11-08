package com.mustache.bbs2.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "article2")
@NoArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db에 id생성을 맡기겠다.
    private Long id;
    private String title;

    public Article(String title) {
        this.title = title;
    }
}
