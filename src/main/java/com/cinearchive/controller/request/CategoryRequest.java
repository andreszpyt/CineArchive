package com.cinearchive.controller.request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name) {
}
