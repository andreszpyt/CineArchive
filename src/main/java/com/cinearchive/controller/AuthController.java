package com.cinearchive.controller;

import com.cinearchive.controller.request.UserRequest;
import com.cinearchive.controller.response.UserResponse;
import com.cinearchive.entity.User;
import com.cinearchive.mapper.UserMapper;
import com.cinearchive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        User user = userRepository.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toResponse(user));
    }


}
