package com.hospital.review.domain;

import com.hospital.review.domain.dto.VisitResponse;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id") // foreign key의 column명
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String disease;

    private float amount;

    public VisitResponse toResponse() {
        return VisitResponse.builder()
                .hospitalName(this.hospital.getHospitalName())
                .userName(this.user.getUserName())
                .disease(this.disease)
                .amount(this.amount)
                .build();
    }
}