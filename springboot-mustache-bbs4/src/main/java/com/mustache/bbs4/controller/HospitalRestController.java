package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.domain.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//ResponseEntity<HospitalResponse(dto생략)> 로 return
@RestController //데이터를 제공하고자 restcontroller 제작. ui를 통한게 아니라 json형식으로
@RequestMapping("/api/v1/hospitals") //api/v1을 붙여 api기능을 한다는 암시
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse = Hospital.of(hospital.get());
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
