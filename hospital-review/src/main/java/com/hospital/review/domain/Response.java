package com.hospital.review.domain;

//모든 response는 이 객체로 감싸서 return. (join, login, review ... dto들)

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> {
    private String resultCode; //무슨 에러가 났는지
    private T result;

    private static Response<Void> error(String resultCode) {
        return new Response(resultCode, null);
    }

    public static <T> Response<T> success(T result) {
        return new Response("SUCCESS", result);
    }

}
