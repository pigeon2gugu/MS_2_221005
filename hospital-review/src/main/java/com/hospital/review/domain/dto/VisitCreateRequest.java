package com.hospital.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class VisitCreateRequest {

    private Long userId;
    private Integer hospitalId;
    private String disease;
    private float amount;

}
