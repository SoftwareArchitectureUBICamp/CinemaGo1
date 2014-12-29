package com.team1.cinemaGo.service;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.cinemaGo.dao.MovieSessionDAO;
import com.team1.cinemaGo.model.MovieSession;

@Service("movieSessionService")
@Transactional
public class MovieSessionServiceImpl implements MovieSessionService {

	@Autowired
	private MovieSessionDAO movieSessionDAO;
	
	@Override
	@Transactional
	public void addMovieSession(MovieSession movieSession) throws IOException {
		if (insertControl(movieSession)){
			movieSessionDAO.addMovieSession(movieSession);
		} else
		{
			throw new IOException("Error: Can not save record! New movie session is overlaping with another movie session! Make sure you have 30 min break between sessions.<br>" + movieSession.toString());
		}
	}

	@Override
	@Transactional
	public void updateMovieSession(MovieSession movieSession) throws IOException {
		if (insertControl(movieSession)){
			movieSessionDAO.updateMovieSession(movieSession);
		} else
		{
			throw new IOException("Error: Can not save record! New movie session is overlaping with another movie session! Make sure you have 30 min break between sessions.<br>" + movieSession.toString());			
		}

	}

	@Override
	@Transactional
	public MovieSession getMovieSessionById(Long id) {
		return movieSessionDAO.getMovieSessionById(id);
	}

	@Override
	@Transactional
	public List<MovieSession> listMovieSession() {
		return movieSessionDAO.listMovieSession();
	}

	@Override
	@Transactional
	public void removeMovieSession(Long id) {
		movieSessionDAO.removeMovieSession(id);
	}
	
	private boolean insertControl(final MovieSession session){

		boolean canInsert = true;
		List<MovieSession> tmpsess = movieSessionDAO.listMovieSession();
		
		MovieSession old = movieSessionDAO.getMovieSessionById(session.getId());
		
		if (old != null) {
			tmpsess.remove(old);
		}
		
		tmpsess.add(session);
		Collections.sort(tmpsess, MovieSession.Comparators.CINEMADATE);

		//Filter list by session's cinema
		List<MovieSession> sess = tmpsess.stream().filter(p -> p.getCinema().getId() == session.getCinema().getId()).collect(Collectors.toList());		
				
		for (int i=0; i < sess.size()-1; i++){
			
			Duration b1 = Duration.between(sess.get(i).getEndTime().plusMinutes(30), sess.get(i+1).getStartTime());
			
			if (b1.toMinutes() < 0){
				canInsert = false;
				break;
			}
		}
		
		return canInsert;

	}
	
	public List<MovieSession> getActiveSessions() {
		
		LocalDateTime now = LocalDateTime.now();
		List<MovieSession> allSessions = movieSessionDAO.listMovieSession();
		List<MovieSession> filteredSessions = new ArrayList<MovieSession>();
		
		filteredSessions = allSessions.stream().filter(s -> s.getStartTime().isAfter(now)).collect(Collectors.toList());
		return filteredSessions;
		
	}

	public List<MovieSession> getSessionsForDateInterval(LocalDateTime fromDate, LocalDateTime toDate) {
		
		List<MovieSession> allSessions = movieSessionDAO.listMovieSession();
		List<MovieSession> filteredSessions = new ArrayList<MovieSession>();
		
		filteredSessions = allSessions.stream().filter(s -> s.getStartTime().toLocalDate().isAfter(fromDate.minusDays(1).toLocalDate())
														 && s.getStartTime().toLocalDate().isBefore(toDate.plusDays(1).toLocalDate())).collect(Collectors.toList());
		return filteredSessions;
		
	}
	
	
}
