package com.team1.cinemaGo.model;

import java.util.HashSet;
import java.util.Set;

public class OrderItem {
	
	private MovieSession session;
	private Set<Integer> seats = new HashSet<Integer>();
	
	public MovieSession getSession() {
		return session;
	}
	public void setSession(MovieSession session) {
		this.session = session;
	}
	public Set<Integer> getSeats() {
		return seats;
	}
	public void setSeats(Set<Integer> seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "OrderSession [session=" + session + ", seats=" + seats + "]";
	}

	
}
