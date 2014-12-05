package com.team1.cinemaGo.service;

import java.util.List;

import com.team1.cinemaGo.model.Cinema;

public interface CinemaService {

	public void addCinema(Cinema cinema);
    public void updateCinema(Cinema cinema);
    public Cinema getCinemaById(Integer id);
    public List<Cinema> listCinemas();
    public void removeCinema(Integer id);	
	
}
