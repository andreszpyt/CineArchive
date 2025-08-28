package com.cinearchive.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record UserRequest(@NotEmpty(message = "Name Required") String name,
                          @NotEmpty(message = "Email Required") String email,
                          @NotEmpty(message = "Password Required") String password) {
}
