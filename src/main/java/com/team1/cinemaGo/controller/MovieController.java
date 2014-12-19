package com.team1.cinemaGo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;










import com.team1.cinemaGo.dao.MovieDAO;
import com.team1.cinemaGo.model.Movie;
import com.team1.cinemaGo.service.CinemaService;
import com.team1.cinemaGo.service.MovieService;


//@RestController 
@Controller 
@RequestMapping(value="/movies")
public class MovieController {
	
	@Autowired(required=true)
	private MovieService movieService;
    
    public void setMovieService(MovieService ms){
        this.movieService = ms;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public List<Movie> getMovies(Model model) {
    	List<Movie> movies = movieService.listMovie();
		model.addAttribute("movies", movies);
    	return movies;
	}

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getMovie(@PathVariable int id, Model model) {
		Movie movie = movieService.getMovieById(id);
		model.addAttribute("movie", movie);		
		return "movies";
	}


}
