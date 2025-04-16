package com.ohgiraffers.userservice.query.mapper;

import com.ohgiraffers.userservice.query.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long userId);
}
