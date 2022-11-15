package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.service.HospitalService;
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

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // ResponseEntity도 DTO타입
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로
    }
}