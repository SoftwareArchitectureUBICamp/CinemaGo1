package com.team1.cinemaGo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Session {

	private LocalDateTime startTime;
	private Movie movie;
	private Cinema cinema;
	private int sessionType;
	private BigDecimal price;
		
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime localDateTime) {
		this.startTime = localDateTime;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public LocalDateTime getEndTime() {
		return this.startTime.plusMinutes(this.movie.getDuration().toMinutes());
	}
		
	public int getSessionType() {
		return sessionType;
	}
	public void setSessionType(int sessionType) {
		this.sessionType = sessionType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	//Comparators for sort method
	public static class Comparators {
	    public static final Comparator<Session> DATE = (Session o1, Session o2) -> o1.startTime.compareTo(o2.startTime);
	    public static final Comparator<Session> MOVIE = (Session o1, Session o2) -> o1.movie.getMovieTitle().compareTo(o2.movie.getMovieTitle());
	    public static final Comparator<Session> CINEMA = (Session o1, Session o2) -> o1.cinema.getCinemaName().compareTo(o2.cinema.getCinemaName());
	    public static final Comparator<Session> CINEMADATE = (Session o1, Session o2) -> CINEMA.thenComparing(DATE).compare(o1, o2);
	}

	@Override
	public String toString() {
		return "Session [startTime=" + startTime + ", movie=" + movie.getMovieTitle()
				+ ", cinema=" + cinema.getCinemaName() + ", sessionType=" + sessionType + "]";
	}
	
}
