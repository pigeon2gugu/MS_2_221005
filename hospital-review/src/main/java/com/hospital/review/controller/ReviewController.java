package com.hospital.review.controller;


import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;
    @PostMapping
    public ResponseEntity<String> writeReview(@RequestBody ReviewCreateRequest dto, Authentication authentication) {
        return ResponseEntity.ok()
                .body(reviewService.write(authentication.getName()));
    }
}
