package com.cinearchive.mapper;

import com.cinearchive.controller.request.MovieRequest;
import com.cinearchive.controller.response.CategoryResponse;
import com.cinearchive.controller.response.MovieResponse;
import com.cinearchive.controller.response.StreamingResponse;
import com.cinearchive.entity.Category;
import com.cinearchive.entity.Movie;
import com.cinearchive.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public Movie toMovie(MovieRequest request) {

        List<Category> categoryList = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId.getId()).build())
                .toList();

        List<Streaming> streamingList = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId.getId()).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .createdAt(request.createdAt())
                .updatedAt(request.updatedAt())
                .categories(categoryList)
                .streamings(streamingList)
                .build();
    }

    public MovieResponse toResponse(Movie movie) {

        List<CategoryResponse> categoryResponseList = movie.getCategories().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        List<StreamingResponse> streamingResponseList = movie.getStreamings().stream()
                .map(StreamingMapper::toResponse)
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .categories(categoryResponseList)
                .streamings(streamingResponseList)
                .build();
    }
}
