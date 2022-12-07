package com.hospital.review.service;

import com.hospital.review.domain.Hospital;
import com.hospital.review.domain.User;
import com.hospital.review.domain.Visit;
import com.hospital.review.domain.dto.VisitCreateRequest;
import com.hospital.review.exception.ErrorCode;
import com.hospital.review.exception.HospitalReviewAppException;
import com.hospital.review.repository.HospitalRepository;
import com.hospital.review.repository.UserRepository;
import com.hospital.review.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;

    public void createVisit(VisitCreateRequest dto, String userName) {

        // hospital이 없을 때 등록불가
        Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUNDED_HOSPITAL_NAME, String.format("hospitalId:%s 가 없습니다.", dto.getHospitalId())));

        // user가 없을 때 등록불가
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUNDED_USER_NAME, String.format("%s user가 없습니다.", userName)));

        Visit visit = Visit.builder()
                .user(user)
                .hospital(hospital)
                .disease(dto.getDisease())
                .amount(dto.getAmount())
                .build();
        visitRepository.save(visit);
    }

}
