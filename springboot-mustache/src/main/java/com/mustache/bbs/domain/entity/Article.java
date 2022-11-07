package com.mustache.bbs.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //jpa에서 객체로 다루겠다는 선언
@NoArgsConstructor
@Getter
public class Article {
    @Id //@Entity가 있다면 id가 꼭 필요. primary key를 의미
    @GeneratedValue //autoincrement 기능. id를 직접 생성하지 않고, 자동으로 생성하도록 함
    private Long id;
    private String title;
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
