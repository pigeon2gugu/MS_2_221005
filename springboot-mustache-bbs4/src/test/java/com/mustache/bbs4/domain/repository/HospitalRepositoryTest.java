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
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameInAndRoadNameAddressContaining(inClues, address);

        for(var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

}