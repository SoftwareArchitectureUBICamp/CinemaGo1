package com.team1.cinemaGo.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
	
	private List<MovieSession> sessions = new ArrayList<MovieSession>();
	
	public void add(MovieSession session){
		
		if (insertControl(session)){
			this.sessions.add(session);
			System.out.println("Inser successful! (" + session.getStartTime() + "-" + session.getEndTime() +")");
		} else
		{
			System.out.println("Schedule OVERLAP! (" + session.getStartTime() + "-" + session.getEndTime() +")");
		}
				
	}
	
	public void remove(int index){
		
		this.sessions.remove(index);
				
	}
	
	public void set(int index, MovieSession session) {
		
		if (insertControl(session)){
			this.sessions.set(index, session);
			System.out.println("Update successful! (" + session.getStartTime() + "-" + session.getEndTime() +")");
		} else
		{
			System.out.println("Schedule OVERLAP! (" + session.getStartTime() + "-" + session.getEndTime() +")");
		}
	}
	
	public void sort(){

		Collections.sort(sessions, MovieSession.Comparators.CINEMADATE);

	}
	
	private boolean insertControl(final MovieSession session){

		boolean canInsert = true;
		List<MovieSession> tmpsess = new ArrayList<MovieSession>(sessions);
		
		tmpsess.add(session);
		Collections.sort(tmpsess, MovieSession.Comparators.CINEMADATE);

		//Filter list by session's cinema
		List<MovieSession> sess = tmpsess.stream().filter(p -> p.getCinema().getCinemaName() == session.getCinema().getCinemaName()).collect(Collectors.toList());		
				
		for (int i=0; i < sess.size()-1; i++){
			
			Duration b1 = Duration.between(sess.get(i).getEndTime().plusMinutes(30), sess.get(i+1).getStartTime());
			
			if (b1.toMinutes() < 0){
				canInsert = false;
				break;
			}
		}
		
		return canInsert;

	}

	public List<MovieSession> getSessions() {
		return sessions;
	}

	public List<MovieSession> getActiveSessions() {
		
		LocalDateTime now = LocalDateTime.now();
		List<MovieSession> filteredSessions = new ArrayList<MovieSession>();
		
		filteredSessions = sessions.stream().filter(s -> s.getStartTime().isAfter(now)).collect(Collectors.toList());
		return filteredSessions;
		
	}
	
	public void setSessions(List<MovieSession> sessions) {
		this.sessions = sessions;
	}


}
