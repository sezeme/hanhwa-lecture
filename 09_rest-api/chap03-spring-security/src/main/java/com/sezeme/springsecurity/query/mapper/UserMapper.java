package com.sezeme.springsecurity.query.mapper;

import com.sezeme.springsecurity.query.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDTO findUserByUsername(String username);

    List<UserDTO> findAllUsers();
}
