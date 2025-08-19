package com.cinearchive.service;

import com.cinearchive.entity.Movie;
import com.cinearchive.repository.MovieRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRespository movieRespository;

    public List<Movie> findAll() {
        return movieRespository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRespository.findById(id);
    }

    public Movie save(Movie movie) {
        return movieRespository.save(movie);
    }

    public void deleteById(Long id) {
        movieRespository.deleteById(id);
    }

    public Movie update(Movie movie, Long id) {
        movie.setId(id);
        return movieRespository.save(movie);
    }
}