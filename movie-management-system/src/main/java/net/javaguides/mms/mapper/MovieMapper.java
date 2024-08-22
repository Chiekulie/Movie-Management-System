package net.javaguides.mms.mapper;

import net.javaguides.mms.dto.MovieDto;
import net.javaguides.mms.entity.Movie;

public class MovieMapper {

    // Convert Movie entity to MovieDto
    public static MovieDto toMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setReleaseYear(movie.getReleaseYear());
        movieDto.setGenre(movie.getGenre());
        movieDto.setActor(movie.getActor());
        return movieDto;
    }

    // Convert MovieDto to Movie entity
    public static Movie toMovieEntity(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setGenre(movieDto.getGenre());
        movie.setActor(movieDto.getActor());
        return movie;
    }
}
