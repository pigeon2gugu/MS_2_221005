package com.example.app_2022_12_19__1.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private String resultCode; //성공 S, 실패 F
    private String msg;
    private T data;

}
