package com.hospital.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    //private final ReviewRepository reviewRepository;

    public String write(String userName) {
        return userName + " 의 리뷰가 등록되었습니다.";
    }
}
