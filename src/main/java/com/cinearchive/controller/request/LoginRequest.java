package com.cinearchive.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "email mandatory") String email,
                           @NotEmpty(message = "Password Mandatory") String password) {
}
