package com.ohgiraffers.userservice.query.service;

import com.ohgiraffers.userservice.query.dto.UserDTO;
import com.ohgiraffers.userservice.query.dto.UserDetailResponse;
import com.ohgiraffers.userservice.query.dto.UserListResponse;
import com.ohgiraffers.userservice.query.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserMapper userMapper;

    public UserDetailResponse getUserDetail(Long userId) {
        UserDTO user = Optional.ofNullable(
                userMapper.findUserById(userId)
        ).orElseThrow(() -> new RuntimeException("유저 정보 찾지 못함"));

        return UserDetailResponse.builder().user(user).build();
    }

    public UserListResponse getAllUsers() {
        List<UserDTO> users = userMapper.findAllUsers();
        return UserListResponse.builder()
                .users(users)
                .build();
    }

    public String getUserGrade(Long userId) {
        UserDTO user = userMapper.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("유저 정보 찾지 못함");
        }
        // 예시로 사용자 DTO에 grade 필드가 있다고 가정하고 반환
//        return user.getGrade();
        return "PREMIUM";
    }
}
