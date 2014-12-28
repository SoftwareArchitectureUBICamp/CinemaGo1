package com.team1.cinemaGo.dao;

import java.util.List;

import com.team1.cinemaGo.model.MovieSession;

public interface MovieSessionDAO {

	   public void addMovieSession(MovieSession movieSession);
	    public void updateMovieSession(MovieSession movieSession);
	    public List<MovieSession> listMovieSession();
	    public MovieSession getMovieSessionById(long id);
	    public void removeMovieSession(long id);
	
}
