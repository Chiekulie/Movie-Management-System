package net.javaguides.mms.controller;

import net.javaguides.mms.dto.MovieDto;
import net.javaguides.mms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }






    // Handler method to handle list movies
    @GetMapping("/movies")
    public String listMovies(Model model) {
        List<MovieDto> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    // Handler method to handle new movie request
    @GetMapping("/movies/new")
    public String newMovie(Model model) {
        MovieDto movieDto = new MovieDto();
        model.addAttribute("movie", movieDto);
        return "create_movie";
    }

    // Handler method to handle save movie form submit request
    @PostMapping("/movies")
    public String saveMovie(@ModelAttribute("movie") MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return "redirect:/movies";
    }

    // Handler method to handle edit movie request
    @GetMapping("/movies/{movieId}/edit")
    public String editMovie(@PathVariable("movieId") Long movieId, Model model) {
        MovieDto movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "edit_movie";
    }

    // Handler method to handle update movie form submit request
    @PostMapping("/movies/{movieId}")
    public String updateMovie(@PathVariable("movieId") Long movieId, @ModelAttribute("movie") MovieDto movieDto) {
        movieDto.setId(movieId);
        movieService.updateMovie(movieDto);
        return "redirect:/movies";
    }

    // Handler method to handle delete movie request
    @GetMapping("/movies/{movieId}/delete")
    public String deleteMovie(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovie(movieId);
        return "redirect:/movies";
    }

    // Handler method to handle view movie request
    @GetMapping("/movies/{movieId}/view")
    public String viewMovie(@PathVariable("movieId") Long movieId, Model model) {
        MovieDto movieDto = movieService.getMovieById(movieId);
        model.addAttribute("movie", movieDto);
        return "view_movie";
    }

    // Handler method to handle search by actor name
    @GetMapping("/movies/search")
    public String searchMoviesByActor(@RequestParam("actor") String actor, Model model) {
        List<MovieDto> movies = movieService.searchMoviesByActor(actor);
        model.addAttribute("movies", movies);
        return "movies";
    }
}

