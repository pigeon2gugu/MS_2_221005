package com.example.app_2022_12_19__1.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WriteMessageRequest {
    private String authorName;
    private String content;

    public WriteMessageRequest(String authorName, String content) {
        this.authorName = authorName;
        this.content = content;
    }
}
