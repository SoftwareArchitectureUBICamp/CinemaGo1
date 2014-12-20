package com.team1.cinemaGo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team1.cinemaGo.model.Movie;
import com.team1.cinemaGo.service.MovieService;


@Controller 
@RequestMapping(value="/movies")
public class MovieController {
	
	@Autowired(required=true)
	@Qualifier(value="movieService")
	private MovieService movieService;
    
    public void setMovieService(MovieService ms){
        this.movieService = ms;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getMovies(Model model) {
    	
    	List<Movie> movies = movieService.listMovie();
		model.addAttribute("movie",new Movie());
    	model.addAttribute("movies", movies);
    	
		return "movies";
	}

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public String getMovie(@PathVariable int id, Model model) {
		Movie movie = movieService.getMovieById(id);
		model.addAttribute("movie", movie);		
		
		return "moviesForm";
	}
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String removeMovie(@PathVariable int id, Model model) {
		
    	movieService.removeMovie(id);
		return "redirect:/movies/";
		
	}
 
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String setMovie(@ModelAttribute("movie") Movie movie, BindingResult result) {

    	movieService.addMovie(movie);
    	
		return "redirect:/movies/";
	}

}
