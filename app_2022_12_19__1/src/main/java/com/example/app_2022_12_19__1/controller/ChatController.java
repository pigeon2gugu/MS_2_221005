package com.example.app_2022_12_19__1.controller;

import com.example.app_2022_12_19__1.domain.ChatMessage;
import com.example.app_2022_12_19__1.domain.RsData;
import com.example.app_2022_12_19__1.response.WriteMessageRequest;
import com.example.app_2022_12_19__1.response.WriteMessageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private List<ChatMessage> chatMessages = new ArrayList<>();


    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<ChatMessage> writeMessage(@RequestBody WriteMessageRequest request) {
        ChatMessage message = new ChatMessage(request.getAuthorName(), request.getContent());
        chatMessages.add(message);

        return new RsData<>("S-1",
                "메세지가 작성되었습니다.",
                message);

    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<List<ChatMessage>> messages() {
        return new RsData<>("S-1",
                "메세지 목록 불러오기 성공",
                chatMessages);
    }

}
