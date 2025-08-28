package com.cinearchive.controller.request;

import com.cinearchive.entity.Category;
import com.cinearchive.entity.Streaming;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MovieRequest(@NotEmpty(message = "Title Required") String title,
                           String description,
                           LocalDate releaseDate,
                           double rating,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt,
                           List<Category> categories,
                           List<Streaming>  streamings) {
}
