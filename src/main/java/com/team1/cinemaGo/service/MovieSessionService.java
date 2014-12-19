package com.team1.cinemaGo.service;

import java.util.List;

import com.team1.cinemaGo.model.MovieSession;

public interface MovieSessionService {

	public void addMovieSession(MovieSession movieSession);
    public void updateMovieSession(MovieSession movieSession);
    public MovieSession getMovieSessionById(Integer id);
    public List<MovieSession> listMovieSession();
    public void removeMovieSession(Integer id);	
	
}
