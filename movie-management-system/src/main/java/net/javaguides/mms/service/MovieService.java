package net.javaguides.mms.service;

import net.javaguides.mms.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();
    MovieDto getMovieById(Long id);
    void createMovie(MovieDto movieDto);
    void updateMovie(MovieDto movieDto);
    void deleteMovie(Long id);
    List<MovieDto> searchMoviesByActor(String actor);
}
