package com.mustache.bbs4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;

    //Json형식
    //{id:"", roadNameAddress:"", hospitalName:"",patientRoomCount:"", totalNumberOfBeds:"", businessTypeName:"",totalAreaSize:""}
}