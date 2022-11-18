package com.mustache.bbs4.service;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.domain.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp(){
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("영업 코드 잘 나오는가")

/*    {"id":1,"roadNameAddress":"광주광역시 북구 동문대로 24, 3층 (풍향동)","hospitalName":"효치과의원",
            "patientRoomCount":0,"totalNumberOfBeds":0,"businessTypeName":"치과의원",
            "businessStatusName":"영업중","totalAreaSize":52.29}*/

    void statusTest() {
        Mockito.when(hospitalRepository.findById(1))
                .thenReturn(Optional.of(new Hospital(1, "광주광역시 북구 동문대로 24, 3층 (풍향동)", "효치과의원",
                        0, 0, "치과의원",
                        13, (float) 52.29)));

        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
        assertEquals("영업중", hospitalResponse.getBusinessStatusName());
    }


}