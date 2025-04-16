package com.ohgiraffers.userservice.query.controller;

import com.ohgiraffers.userservice.common.ApiResponse;
import com.ohgiraffers.userservice.query.dto.UserDetailResponse;
import com.ohgiraffers.userservice.query.dto.UserListResponse;
import com.ohgiraffers.userservice.query.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserQueryController {

    private final UserQueryService userQueryService;

    @GetMapping("/users/me")
    public ResponseEntity<ApiResponse<UserDetailResponse>> getUserDetail(
            @AuthenticationPrincipal String userId
    ) {
        /* username에 담긴 값이 userId(숫자) */
        UserDetailResponse response = userQueryService.getUserDetail(Long.valueOf(userId));
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/users")
    public ResponseEntity<ApiResponse<UserListResponse>> getUsers() {
        UserListResponse response = userQueryService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 사용자 ID로 등급 확인, 예를 들어 BASIC, PREMIUM 등
    @GetMapping("/users/{userId}/grade")
    public ResponseEntity<ApiResponse<String>> getUserGrade(@PathVariable("userId") Long userId) {
        String grade = userQueryService.getUserGrade(userId);
        return ResponseEntity.ok(ApiResponse.success(grade));
    }

}
