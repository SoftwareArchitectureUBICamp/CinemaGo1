package com.team1.cinemaGo.model;

import com.team1.cinemaGo.run.LocalDateTimePersistenceConverter;
import java.time.LocalDateTime;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="t_session",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"start_time", "cinema_id"})})
public class Session {

	@Id
	@Column(name="session_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="start_time")
	@Convert(converter = LocalDateTimePersistenceConverter.class)
	private LocalDateTime startTime;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="movie_id")
	private Movie movie;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cinema_id")
	private Cinema cinema;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="session_type_id")
	private SessionType sessionType;
		
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
		return this.startTime.plusMinutes(this.movie.getDuration());
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SessionType getSessionType() {
		return sessionType;
	}
	public void setSessionType(SessionType sessionType) {
		this.sessionType = sessionType;
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
		return "[" + cinema.getCinemaName() + "] '" + movie.getMovieTitle()+ "': date: " + startTime.toLocalDate() + "; time: " + startTime.toLocalTime() + "-" + this.getEndTime().toLocalTime() + " (duration=" + movie.getDuration() + "min)";
	}
	
}
