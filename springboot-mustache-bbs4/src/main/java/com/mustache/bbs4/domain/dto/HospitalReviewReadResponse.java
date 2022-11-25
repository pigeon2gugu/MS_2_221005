package com.mustache.bbs4.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class HospitalReviewReadResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String hospitalName;
}
