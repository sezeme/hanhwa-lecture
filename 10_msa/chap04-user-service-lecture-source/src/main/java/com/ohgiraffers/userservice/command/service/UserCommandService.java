package com.ohgiraffers.userservice.command.service;

import com.ohgiraffers.userservice.command.dto.UserCreateRequest;
import com.ohgiraffers.userservice.command.entity.User;
import com.ohgiraffers.userservice.command.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserCreateRequest request) {
       // 중복 회원 체크 로직 등 추가 가능
       User user = modelMapper.map(request, User.class);
       user.setEncodedPassword(passwordEncoder.encode(request.getPassword()));
       userRepository.save(user);
    }
}
