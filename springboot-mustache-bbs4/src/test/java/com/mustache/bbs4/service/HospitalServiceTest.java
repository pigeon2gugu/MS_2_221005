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

/*    {"id":74581,"roadNameAddress":"서울특별시 중구 퇴계로 127 (충무로2가,2층)","hospitalName":"아이리스치과의원",
            "patientRoomCount":0,"totalNumberOfBeds":0,"businessTypeName":"치과의원",
            "businessStatusName":"폐업","totalAreaSize":195.0}*/

    void statusTest() {
        Mockito.when(hospitalRepository.findById(1))
                .thenReturn(Optional.of(new Hospital(1, "광주광역시 북구 동문대로 24, 3층 (풍향동)", "효치과의원",
                        0, 0, "치과의원",
                        13, (float) 52.29)));

        Mockito.when(hospitalRepository.findById(74581))
                .thenReturn(Optional.of(new Hospital(74581, "서울특별시 중구 퇴계로 127 (충무로2가,2층)", "아이리스치과의원",
                        0, 0, "치과의원",
                        3, (float) 195.0)));


        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
        HospitalResponse hospitalResponse2 = hospitalService.getHospital(74581);

        assertEquals("영업중", hospitalResponse.getBusinessStatusName());
        assertEquals("폐업", hospitalResponse2.getBusinessStatusName());
    }


}