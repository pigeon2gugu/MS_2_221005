package com.hospital.review.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "User name is duplicated."),
    NOT_FOUNDED_USER_NAME(HttpStatus.NOT_FOUND, "UserName is not founded"),
    NOT_FOUNDED_HOSPITAL_NAME(HttpStatus.NOT_FOUND, "Hospital is not Found"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "Password is Wrong");



    private HttpStatus status;
    private String message;
}
