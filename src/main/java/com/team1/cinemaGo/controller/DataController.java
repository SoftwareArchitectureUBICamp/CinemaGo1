package com.team1.cinemaGo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team1.cinemaGo.model.MovieSession;
import com.team1.cinemaGo.service.MovieSessionService;


@Controller
@RequestMapping("/")
public class DataController {

	private MovieSessionService movieSessionService;
	
    @Autowired(required=true)
    @Qualifier(value="movieSessionService")
    public void setCinemaService(MovieSessionService cs){
        this.movieSessionService = cs;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String mainIndex(Model model) {
		
		List<MovieSession> movieSessionsToday = movieSessionService.getSessionsForDateInterval(LocalDateTime.now(), LocalDateTime.now());
		List<MovieSession> movieSessionsTomorrow = movieSessionService.getSessionsForDateInterval(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1));
		List<MovieSession> movieSessions = movieSessionService.getSessionsForDateInterval(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusMonths(6));
				
		model.addAttribute("movieSessions", movieSessions);
		model.addAttribute("movieSessionsToday", movieSessionsToday);
		model.addAttribute("movieSessionsTomorrow", movieSessionsTomorrow);
		
		
//		movieSessions.get(0).getStartTime().toLocalDate().toString()
		
		return "index";
	
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminIndex(Model model) {
			    
		return "admin";
	
	}
	
}
