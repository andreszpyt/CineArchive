package com.cinearchive.config;

import lombok.Builder;

@Builder
public record JwtUserData(Long id, String name, String email) {
}
