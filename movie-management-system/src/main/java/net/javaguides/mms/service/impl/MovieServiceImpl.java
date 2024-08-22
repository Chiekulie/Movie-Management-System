package net.javaguides.mms.service.impl;

import net.javaguides.mms.dto.MovieDto;
import net.javaguides.mms.entity.Movie;
import net.javaguides.mms.mapper.MovieMapper;
import net.javaguides.mms.repository.MovieRepository;
import net.javaguides.mms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        return MovieMapper.toMovieDto(movie);
    }

    @Override
    public void createMovie(MovieDto movieDto) {
        Movie movie = MovieMapper.toMovieEntity(movieDto);
        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        Movie movie = MovieMapper.toMovieEntity(movieDto);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieDto> searchMoviesByActor(String actor) {
        return movieRepository.findByActorContainingIgnoreCase(actor).stream()
                .map(MovieMapper::toMovieDto)
                .collect(Collectors.toList());
    }
}
