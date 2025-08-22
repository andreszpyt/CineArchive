package com.cinearchive.mapper;

import com.cinearchive.controller.request.UserRequest;
import com.cinearchive.controller.response.UserResponse;
import com.cinearchive.entity.User;
import lombok.Builder;
import lombok.experimental.UtilityClass;

@Builder
@UtilityClass
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
