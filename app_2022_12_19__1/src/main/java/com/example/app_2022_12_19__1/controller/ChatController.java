package com.example.app_2022_12_19__1.controller;

import com.example.app_2022_12_19__1.domain.ChatMessage;
import com.example.app_2022_12_19__1.domain.RsData;
import com.example.app_2022_12_19__1.response.MessageListRequest;
import com.example.app_2022_12_19__1.response.MessageListResponse;
import com.example.app_2022_12_19__1.response.WriteMessageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

/*
    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessageListResponse> messages() {
        return new RsData<>("S-1",
                "메세지 목록 불러오기 성공",
                new MessageListResponse(chatMessages));
    }
*/

    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessageListResponse> messagesFrom(MessageListRequest request) {

        List<ChatMessage> messages = chatMessages;

        //번호가 입력되어있다면
        if(request.getFromId() != null) {
            //해당 번호의 체팅메세지가 전체 리스트에서의 배열인덱스 번호를 구함.
            //없다면 -1
            int index = IntStream.range(0, messages.size())
                    .filter(i -> chatMessages.get(i).getId() == request.getFromId())
                    .findFirst()
                    .orElse(-1);

            if(index != -1) {
                messages = messages.subList(index+1, messages.size());
            }
        }


        return new RsData<>("S-1",
                "메세지 목록 불러오기 성공",
                new MessageListResponse(messages));
    }

    //채팅방
    @GetMapping("/room")
    public String showRoom() {
        return "chat/room";
    }

}
