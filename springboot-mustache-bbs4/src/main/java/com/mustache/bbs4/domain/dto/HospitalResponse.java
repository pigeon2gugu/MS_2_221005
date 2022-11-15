package com.mustache.bbs4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;

    //Json형식
    //{id:"", roadNameAddress:"", hospitalName:"",patientRoomCount:"", totalNumberOfBeds:"", businessTypeName:"",totalAreaSize:""}
}