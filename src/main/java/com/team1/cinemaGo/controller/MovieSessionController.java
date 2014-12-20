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

import com.team1.cinemaGo.model.MovieSession;
import com.team1.cinemaGo.service.MovieSessionService;

@Controller
@RequestMapping(value="/moviesessions")
public class MovieSessionController {

	
	@Autowired(required=true)
	@Qualifier(value="movieSessionService")
	private MovieSessionService movieSessionService;
    
    public void setMovieSessionService(MovieSessionService movieSessionService){
        this.movieSessionService = movieSessionService;
    }	
	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getMovieSessions(Model model) {
		
    	List<MovieSession> movieSessions = movieSessionService.listMovieSession();
		
		model.addAttribute("movieSession", new MovieSession());
		model.addAttribute("movieSessions", movieSessions);
		return "movieSessions";
	}
    

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public String getMovieSessionById(@PathVariable int id, Model model) {
		
    	MovieSession movieSession = movieSessionService.getMovieSessionById(id);
    	
    	model.addAttribute("movieSession", movieSession);
		return "movieSessionsForm";
	}

    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String removeMovieSession(@PathVariable int id, Model model) {
		
    	movieSessionService.removeMovieSession(id);
		return "redirect:/moviesessions/";
	}

    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String setMovieSession(@ModelAttribute("movieSession") MovieSession movieSession,
            BindingResult result) {
		
    	movieSessionService.addMovieSession(movieSession);
    	
		return "redirect:/moviesessions/";
	}
	
}
