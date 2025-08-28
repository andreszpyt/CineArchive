package com.cinearchive.controller;

import com.cinearchive.controller.request.MovieRequest;
import com.cinearchive.controller.response.MovieResponse;
import com.cinearchive.entity.Movie;
import com.cinearchive.mapper.MovieMapper;
import com.cinearchive.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movieResponses = movieService.findAll().stream()
                .map(MovieMapper::toResponse)
                .toList();
        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@Valid @RequestBody MovieRequest request) {
        Movie movie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toResponse(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@Valid @RequestBody MovieRequest request, @PathVariable Long id) {
        Movie movie = MovieMapper.toMovie(request);
        Movie updatedMovie = movieService.update(movie, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toResponse(updatedMovie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}