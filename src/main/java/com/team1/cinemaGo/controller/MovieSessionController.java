package com.team1.cinemaGo.controller;

import java.io.IOException;
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

import com.team1.cinemaGo.model.Cinema;
import com.team1.cinemaGo.model.Movie;
import com.team1.cinemaGo.model.MovieSession;
import com.team1.cinemaGo.model.SessionType;
import com.team1.cinemaGo.service.CinemaService;
import com.team1.cinemaGo.service.MovieService;
import com.team1.cinemaGo.service.MovieSessionService;
import com.team1.cinemaGo.service.SessionTypeService;

@Controller
@RequestMapping(value="admin/moviesessions")
public class MovieSessionController {

	
	@Autowired(required=true)
	@Qualifier(value="movieSessionService")
	private MovieSessionService movieSessionService;
	
	@Autowired(required=true)
	private MovieService movieService;

	@Autowired(required=true)
	private CinemaService cinemaService;

	@Autowired(required=true)
	private SessionTypeService sessionTypeService;


    public void setMovieSessionService(MovieSessionService movieSessionService){
        this.movieSessionService = movieSessionService;
    }	

    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }	

    public void setCinemaService(CinemaService cinemaService){
        this.cinemaService = cinemaService;
    }
    
    public void setSessionTypeService(SessionTypeService sessionTypeService){
        this.sessionTypeService = sessionTypeService;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getMovieSessions(Model model) {
		
    	List<MovieSession> movieSessions = movieSessionService.listMovieSession();
    	List<Movie> movies = movieService.listMovie();
    	List<Cinema> cinemas = cinemaService.listCinemas();
    	List<SessionType> sessionTypes = sessionTypeService.listSessionType();
    	
    	model.addAttribute("movies", movies);
    	model.addAttribute("cinemas", cinemas);
    	model.addAttribute("sessionTypes", sessionTypes);
		
		model.addAttribute("movieSession", new MovieSession());
		model.addAttribute("movieSessions", movieSessions);
		model.addAttribute("error", "");
		
		return "movieSessions";
	}
    

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public String getMovieSessionById(@PathVariable long id, Model model) {
		
    	List<Movie> movies = movieService.listMovie();
    	List<Cinema> cinemas = cinemaService.listCinemas();
    	List<SessionType> sessionTypes = sessionTypeService.listSessionType();
    	
    	model.addAttribute("movies", movies);
    	model.addAttribute("cinemas", cinemas);
    	model.addAttribute("sessionTypes", sessionTypes);

    	
    	MovieSession movieSession = movieSessionService.getMovieSessionById(id);
    	model.addAttribute("movieSession", movieSession);
		
    	return "movieSessionsForm";
	}

    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String removeMovieSession(@PathVariable long id, Model model) {
		
    	movieSessionService.removeMovieSession(id);
		return "redirect:/admin/moviesessions/";
	}

    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String setMovieSession(@ModelAttribute("movieSession") MovieSession movieSession, BindingResult result, Model model) {
		

    	List<Movie> movies = movieService.listMovie();
    	List<Cinema> cinemas = cinemaService.listCinemas();
    	List<SessionType> sessionTypes = sessionTypeService.listSessionType();
    	
    	model.addAttribute("movies", movies);
    	model.addAttribute("cinemas", cinemas);
    	model.addAttribute("sessionTypes", sessionTypes);
    	
    	
    	movieSession.setMovie(movieService.getMovieById(Long.parseLong(movieSession.getMovie().getMovieTitle())));
    	movieSession.setCinema(cinemaService.getCinemaById(Integer.parseInt(movieSession.getCinema().getCinemaName())));
    	movieSession.setSessionType(sessionTypeService.getSessionTypeById(Integer.parseInt(movieSession.getSessionType().getSessionName())));
    	
 
    	try {
//			movieSessionService.addMovieSession(movieSession);
			movieSessionService.updateMovieSession(movieSession);
		} catch (IOException e) {
			model.addAttribute("error", e.getMessage());
		}
    	
    	List<MovieSession> movieSessions = movieSessionService.listMovieSession();
    	model.addAttribute("movieSessions", movieSessions);

		return "movieSessions";
	}
	
}
