package com.hospital.review.service;

import com.hospital.review.domain.User;
import com.hospital.review.domain.dto.UserDto;
import com.hospital.review.domain.dto.UserJoinRequest;
import com.hospital.review.exception.ErrorCode;
import com.hospital.review.exception.HospitalReviewAppException;
import com.hospital.review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import utils.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.token.secret}")
    private String secretKey;

    private long expireTimeMs = 1000 * 60 * 60; //1 hour


    public UserDto join(UserJoinRequest request) {
        //비즈니스 로직 - 회원가입
        //회원 userName(id) 중복 check. 중복시 회원 가입 x -> Exception (예외) 처리. 사용자가 올바른 정보를 주도록 처리.
        //error는 언제 발생할지 예측하기 어려운 것들...
        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> {
                    throw new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("userName : %s", request.getUserName()));
                });

        //회원가입 .save()
        User savedUser = userRepository.save(request.toEntity(encoder.encode(request.getPassword())));

        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmailAddress())
                .build();
    }

    public String login(String userName, String password) {

        //userName이 있는지. 없으면 NOT_FOUND error
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUND, String.format("%s는 맞는 id가 아닙니다.", userName)));

        //password 일치 하는지.
        if(!encoder.matches(password, user.getPassword())) {
            throw new HospitalReviewAppException(ErrorCode.INVALID_PASSWORD, "비밀번호가 일치하지 않습니다.");

        }

        //예외가 안났으면 token 발행. JWT (JSON Web Token)형식의 token

        return JwtTokenUtil.createToken(userName, secretKey, expireTimeMs);
    }
}
