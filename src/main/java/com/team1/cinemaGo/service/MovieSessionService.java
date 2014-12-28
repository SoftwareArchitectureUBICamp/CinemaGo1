package com.team1.cinemaGo.service;

import java.io.IOException;
import java.util.List;

import com.team1.cinemaGo.model.MovieSession;

public interface MovieSessionService {

	public void addMovieSession(MovieSession movieSession) throws IOException;
    public void updateMovieSession(MovieSession movieSession);
    public MovieSession getMovieSessionById(Long id);
    public List<MovieSession> listMovieSession();
    public void removeMovieSession(Long id);	
	
}
