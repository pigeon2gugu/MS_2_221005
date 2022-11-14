package com.mustache.bbs4.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product") // 생략 가능
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number; //상품번호

    @Column(nullable = false) //Not Null
    private String name;

    @Column(nullable = false) //Not Null
    private Integer price;


    @Column(nullable = false) //Not Null
    private Integer stock;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;



}
