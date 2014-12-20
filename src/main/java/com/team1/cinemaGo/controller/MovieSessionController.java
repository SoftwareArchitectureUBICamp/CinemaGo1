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

import com.team1.cinemaGo.model.SessionType;
import com.team1.cinemaGo.service.SessionTypeService;

@Controller
@RequestMapping(value="/moviesessions")
public class MovieSessionController {

	
	@Autowired(required=true)
	@Qualifier(value="sessionTypeService")
	private SessionTypeService sessionTypeService;
    
    public void setSessionTypeService(SessionTypeService sessionTypeService){
        this.sessionTypeService = sessionTypeService;
    }	
	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getSessionType(Model model) {
		List<SessionType> sessionTypes = sessionTypeService.listSessionType();
		
		model.addAttribute("sessionType", new SessionType());
		model.addAttribute("sessionTypes", sessionTypes);
		return "sessionType";
	}
    

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public String getSessionTypeById(@PathVariable int id, Model model) {
		
    	SessionType sessionType = sessionTypeService.getSessionTypeById(id);
    	
    	model.addAttribute("sessionType", sessionType);
		return "sessionTypeForm";
	}

    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String removeSessionType(@PathVariable int id, Model model) {
		
    	sessionTypeService.removeSessionType(id);
		return "redirect:/sessiontypes/";
	}

    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String setSessionType(@ModelAttribute("sessionType") SessionType sessionType,
            BindingResult result) {
		
    	sessionTypeService.addSessionType(sessionType);
 //   	sessionTypeService.updateSessionType(sessionType);
    	
		return "redirect:/sessiontypes/";
	}
	
}
