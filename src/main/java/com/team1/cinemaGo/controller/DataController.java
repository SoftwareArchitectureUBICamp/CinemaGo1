package com.team1.cinemaGo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team1.cinemaGo.model.Cinema;
import com.team1.cinemaGo.service.CinemaService;


@Controller  
public class DataController {

	private CinemaService cinemaService;
	
    @Autowired(required=true)
    @Qualifier(value="cinemaService")
    public void setCinemaService(CinemaService cs){
        this.cinemaService = cs;
    }

	@RequestMapping(value = "/cinema", method = RequestMethod.GET)
	public String listCinemas(Model model) {
		model.addAttribute("cinema", new Cinema());
	    model.addAttribute("listCinemas", this.cinemaService.listCinemas());
	    return "cinema";
	}
	
}
