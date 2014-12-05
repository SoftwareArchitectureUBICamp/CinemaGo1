package com.team1.cinemaGo.dao;

import java.util.List;

import com.team1.cinemaGo.model.Cinema;

public interface CinemaDAO {

    public void addCinema(Cinema cinema);
    public void updateCinema(Cinema cinema);
    public List<Cinema> listCinema();
    public Cinema getCinemaById(int id);
    public void removeCinema(int id);
	
}
