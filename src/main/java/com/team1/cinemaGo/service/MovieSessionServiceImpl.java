package com.team1.cinemaGo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.team1.cinemaGo.dao.MovieSessionDAO;
import com.team1.cinemaGo.model.MovieSession;

public class MovieSessionServiceImpl implements MovieSessionService {

	@Autowired
	private MovieSessionDAO movieSessionDAO;
	
	@Override
	@Transactional
	public void addMovieSession(MovieSession movieSession) {
		movieSessionDAO.addMovieSession(movieSession);
	}

	@Override
	@Transactional
	public void updateMovieSession(MovieSession movieSession) {
		movieSessionDAO.updateMovieSession(movieSession);
	}

	@Override
	@Transactional
	public MovieSession getMovieSessionById(Integer id) {
		return movieSessionDAO.getMovieSessionById(id);
	}

	@Override
	@Transactional
	public List<MovieSession> listMovieSession() {
		return movieSessionDAO.listMovieSession();
	}

	@Override
	@Transactional
	public void removeMovieSession(Integer id) {
		movieSessionDAO.removeMovieSession(id);
	}

	
	
}
