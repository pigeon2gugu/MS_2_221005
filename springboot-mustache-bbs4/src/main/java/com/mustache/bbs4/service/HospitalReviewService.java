package com.mustache.bbs4.service;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.HospitalReview;
import com.mustache.bbs4.domain.dto.HospitalReviewCreateRequest;
import com.mustache.bbs4.domain.dto.HospitalReviewCreateResponse;
import com.mustache.bbs4.domain.dto.HospitalReviewReadResponse;
import com.mustache.bbs4.domain.repository.HospitalRepository;
import com.mustache.bbs4.domain.repository.HospitalReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalReviewService {

    private final HospitalReviewRepository hospitalReviewRepository;
    private final HospitalRepository hospitalRepository;

    public HospitalReviewService(HospitalReviewRepository hospitalReviewRepository, HospitalRepository hospitalRepository) {
        this.hospitalReviewRepository = hospitalReviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalReviewCreateResponse createReview(HospitalReviewCreateRequest dto) {
        Optional<Hospital> hospital = hospitalRepository.findById(dto.getHospitalId());
        HospitalReview review = HospitalReview.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .userName(dto.getUserName())
                .hospital(hospital.get())
                .build();
        HospitalReview savedReview = hospitalReviewRepository.save(review);

        return new HospitalReviewCreateResponse(
                savedReview.getId(), savedReview.getTitle(), savedReview.getContent(),
                savedReview.getUserName(), "리뷰 등록 성공");

    }

    public HospitalReview getReview(Long id) {
        HospitalReview review = hospitalReviewRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("해당 id가 없습니다."));
        return review;
    }

    public List<HospitalReviewReadResponse> findAllByHospitalId(Integer hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다."));

        List<HospitalReviewReadResponse> reviews = hospitalReviewRepository.findByHospital(hospital)
                .stream().map(review ->
                    HospitalReviewReadResponse.builder()
                            .id(review.getId())
                            .title(review.getTitle())
                            .content(review.getContent())
                            .userName(review.getUserName())
                            .hospitalName(review.getHospital().getHospitalName())
                            .build()
                ).collect(Collectors.toList());

        return reviews;
    }
}
