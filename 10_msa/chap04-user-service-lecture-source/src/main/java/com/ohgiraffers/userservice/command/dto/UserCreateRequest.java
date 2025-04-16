package com.ohgiraffers.userservice.command.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCreateRequest {
    private final String username;
    private final String password;
    // 추가 회원 가입 시 필요한 데이터
}
