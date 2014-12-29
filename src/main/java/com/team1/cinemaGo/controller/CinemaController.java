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

import com.team1.cinemaGo.model.Cinema;
import com.team1.cinemaGo.service.CinemaService;


@Controller
@RequestMapping("admin/cinemas")
public class CinemaController {

	
	@Autowired(required=true)
	@Qualifier(value="cinemaService")
	private CinemaService cinemaService;
    
    public void setCinemaService(CinemaService cs){
        this.cinemaService = cs;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getCinemas(Model model) {
    	
    	List<Cinema> cinemas = cinemaService.listCinemas();
		model.addAttribute("cinema",new Cinema());
    	model.addAttribute("cinemas", cinemas);
    	
		return "cinemas";
	}

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public String getCinema(@PathVariable int id, Model model) {
		Cinema cinema = cinemaService.getCinemaById(id);
		model.addAttribute("cinema", cinema);		
		
		return "cinemasForm";
	}
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String removeCinema(@PathVariable int id, Model model) {
		
    	cinemaService.removeCinema(id);
		return "redirect:/admin/cinemas/";
		
	}
 
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String setMovie(@ModelAttribute("cinema") Cinema cinema, BindingResult result) {

    	cinemaService.addCinema(cinema);
		return "redirect:/admin/cinemas/";
	}

	
}
