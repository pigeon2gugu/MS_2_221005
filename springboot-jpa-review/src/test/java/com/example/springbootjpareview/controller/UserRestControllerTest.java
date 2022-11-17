package com.example.springbootjpareview.controller;

import com.example.springbootjpareview.domain.dto.UserResponse;
import com.example.springbootjpareview.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;



    @Test
    @DisplayName("입력한 Id로 조회가 잘 되는지")
    void findById() throws Exception {

        given(userService.getUser(1l)).willReturn(new UserResponse(1l, "하늘", "회원 등록 성공"));
        mockMvc.perform(get("/api/v1/users/1"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andDo(print());
        }

    @Test
    @DisplayName("입력한 Id로 조회 실패 했을 때 message가 잘 나오는지")
    void findByIdFail() throws Exception {
        given(userService.getUser(3l)).willReturn(new UserResponse(null, "", "해당 id의 유저가 없습니다"));
        mockMvc.perform(get("/api/v1/users/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id의 유저가 없습니다"))
                .andDo(print());
    }
}