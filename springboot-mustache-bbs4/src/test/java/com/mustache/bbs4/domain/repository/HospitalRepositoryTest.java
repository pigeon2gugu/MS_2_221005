package com.mustache.bbs4.domain.repository;

import com.mustache.bbs4.domain.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("BusinessTypeName이 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");

        String address = "관악구";
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void containing() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("관악구");
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void startsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith("서울");
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void endswith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("병원"); //의원, 병원, 이비인후과, 치과 ...
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void findByPatientRoomCountAndPatientRoomCount() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10, 20);// 의원, 병원, 이비인후과, 치과
        printHospitalNameAndAddress(hospitals);
    }

    void printHospitalNameAndAddress(List<Hospital> hospitals) {
        for (var hospital : hospitals) {
            System.out.printf("%s | %s %f\n", hospital.getHospitalName(), hospital.getRoadNameAddress(), hospital.getTotalAreaSize());
        }

        System.out.println(hospitals.size());
    }

}