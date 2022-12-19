package com.example.app_2022_12_19__1.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WriteMessageResponse {
    private long id;

    public WriteMessageResponse(long id) {
        this.id = id;
    }
}
