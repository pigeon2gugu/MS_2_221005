package com.mustache.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MustacheController {
    @GetMapping(value = "/hi")
    //Model model parameter : MVC의 M
    public String mustacheCon(Model model) {
        model.addAttribute("username","haneul"); //view에 값을 넘김
        return "greetings"; //greetings라는 이름의 view를 return
    }

    @GetMapping(value = "/hi/{id}")
    //Model model parameter : MVC의 M
    public String mustacheCon2(@PathVariable String id, Model model) {
        model.addAttribute("username","haneul"); //view에 값을 넘김
        model.addAttribute("id", id);
        return "greetings"; //greetings라는 이름의 view를 return
    }
}
