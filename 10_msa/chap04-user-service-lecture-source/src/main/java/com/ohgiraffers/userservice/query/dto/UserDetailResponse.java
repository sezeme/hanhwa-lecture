package com.ohgiraffers.userservice.query.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDetailResponse {
    private UserDTO user;
}
