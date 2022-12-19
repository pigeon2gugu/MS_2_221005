package com.example.app_2022_12_19__1.response;

import com.example.app_2022_12_19__1.domain.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MessageListResponse {
    private List<ChatMessage> chatMessages;

}
