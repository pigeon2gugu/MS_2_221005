package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Post로 API요청
//javascript json형식 데이터 받아오기
//ex) {
//  "name":"kyeongrok",
//  "email":"oceanfog1@gmail.com",
//  "age":36
//}

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    
    @PostMapping("/member")
    //Post에서는 @RequestBody를 주로 사용.
    //json(등)형식으로 넘어온 데이터를 사용할 수 있게 해줌.
    //어떤 타입으로 데이터가 들어올지 Sever입장에서는 예측할 수 없기 때문에 Value를 최상위 class Object로 처리.
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->sb.append(map.getKey()+":"+map.getValue()+"\n"));
        return sb.toString();

    }

    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PostMapping("/member3")
    public ResponseEntity<MemberDto>
    putMember(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
