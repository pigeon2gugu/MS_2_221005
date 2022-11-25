package com.mustache.bbs4.domain.repository;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.HospitalReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalReviewRepository extends JpaRepository<HospitalReview, Long> {
    List<HospitalReview> findByHospital(Hospital hospital);
}
