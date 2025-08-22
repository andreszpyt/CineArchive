package com.cinearchive.controller;

import com.cinearchive.controller.request.LoginRequest;
import com.cinearchive.controller.request.UserRequest;
import com.cinearchive.controller.response.LoginResponse;
import com.cinearchive.controller.response.UserResponse;
import com.cinearchive.entity.User;
import com.cinearchive.mapper.UserMapper;
import com.cinearchive.repository.UserRepository;
import com.cinearchive.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        User user = userRepository.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toResponse(user));
    }

    @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody LoginRequest request) {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);
            User user = (User) authenticate.getPrincipal
            String token = tokenService.generateToken(user);
            return  ResponseEntity.ok(new LoginResponse(token));
        }

}
