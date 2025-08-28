package com.cinearchive.controller.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Name Required") String name) {
}
