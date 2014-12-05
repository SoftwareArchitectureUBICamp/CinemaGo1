package com.team1.cinemaGo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class CinemaController {

	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/{next}/{kitas}")
	public String next(@PathVariable Map<String, String> pathVars , Model model) {
		
		String next = pathVars.get("next");
		String kitas = pathVars.get("kitas");
		
		model.addAttribute("msg", "Nextas yra: " + next);
		model.addAttribute("kitas", "O va kitas yra: " + kitas);
		
		return "next";
		
	}
	
	
	@RequestMapping(value="/form.html", method=RequestMethod.GET)
	public String form(Model model) {
		
		
		return "simpleForm";
	
	}
	
	@RequestMapping(value="/submitForm.html", method=RequestMethod.POST)
	public String submit(HttpServletRequest request, Model model) {
		
		String name = (String) request.getParameter("name");
		
		model.addAttribute("name", name);
		
		return "formResult";
	
	}


	@ModelAttribute
	public void addTitle(Model model){
		model.addAttribute("head", "Hederis viskam");
	}
	
}
