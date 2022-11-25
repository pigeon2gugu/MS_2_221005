package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.HospitalReview;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.domain.dto.HospitalReviewCreateRequest;
import com.mustache.bbs4.domain.dto.HospitalReviewCreateResponse;
import com.mustache.bbs4.domain.dto.HospitalReviewReadResponse;
import com.mustache.bbs4.service.HospitalReviewService;
import com.mustache.bbs4.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//ResponseEntity<HospitalResponse(dto생략)> 로 return
@RestController //데이터를 제공하고자 restcontroller 제작. ui를 통한게 아니라 json형식으로
@RequestMapping("/api/v1/hospitals/reviews") //api/v1을 붙여 api기능을 한다는 암시
@Slf4j
@RequiredArgsConstructor
public class HospitalReviewRestController {

    private final HospitalReviewService hospitalReviewService;


    @PostMapping("/{id}/add")
    public ResponseEntity<HospitalReviewCreateResponse> createReview(@PathVariable Integer id,
                                                                 @RequestBody HospitalReviewCreateRequest dto) {
        return ResponseEntity.ok().body(hospitalReviewService.createReview(dto));

    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalReviewReadResponse> getReview(@PathVariable Long id) {
        HospitalReview review = hospitalReviewService.getReview(id);
        HospitalReviewReadResponse response = HospitalReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .hospitalName("병원 이름 빈칸")
                .build();

        return ResponseEntity.ok().body(response);

    }

}