package com.sezeme.springsecurity.query.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserListResponse {
    private List<UserDTO> users;
}
