package com.cinearchive.controller;

import com.cinearchive.controller.request.MovieRequest;
import com.cinearchive.controller.response.MovieResponse;
import com.cinearchive.entity.Movie;
import com.cinearchive.mapper.MovieMapper;
import com.cinearchive.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> getAllMovies() {
        List<MovieResponse> movieResponses = movieService.findAll().stream()
                .map(MovieMapper::toResponse)
                .toList();
        return movieResponses;
    }

    @GetMapping("/{id}")
    public Optional<MovieResponse> getMovieById(@PathVariable Long id) {
            Optional<Movie> movie = movieService.findById(id);
            if(movie.isPresent()) {
                return Optional.of(MovieMapper.toResponse(movie.get()));
            }
            return Optional.empty();
    }

    @PostMapping
    public MovieResponse addMovie(@RequestBody MovieRequest request) {
        Movie movie = movieService.save(MovieMapper.toMovie(request));
        return MovieMapper.toResponse(movieService.save(movie));
    }

    @PutMapping("/{id}")
    public MovieResponse updateMovie(@RequestBody MovieRequest request, @PathVariable Long id) {
        Movie movie = MovieMapper.toMovie(request);
        Movie updatedMovie = movieService.update(movie, id);
        return MovieMapper.toResponse(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        movieService.deleteById(id);
    }
}
