package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//dispatcherServlet이 매핑해줄 Controller를 등록
@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    //컨트롤러에 어떤 매소드를 할당할 지 정해줌.
    @RequestMapping(value = "/hello", method = RequestMethod.GET) //path
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name") //path
    public String getName() {
        return "Haneul";
    }

    @GetMapping(value = "/variable1/{variable}") //path
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}") //path
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return String.format("%s %s %s", name, email, organization);
    }

    //Map으로 RequestParam받기
    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map) -> {
            System.out.printf("key:%s value:%s", map.getKey(), map.getValue());
        });
        return "완료";
    }

    @GetMapping(value = "/request3")
    public String getRequestParam(MemberDto memberDto) {
        return memberDto.toString();
    }
}
