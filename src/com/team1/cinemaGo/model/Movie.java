package com.team1.cinemaGo.model;

import java.time.Duration;

public class Movie {
	
	private String movieTitle;
	private Duration duration;
	private String description;
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Movie [movieTitle=" + movieTitle + ", duration=" + duration
				+ ", description=" + description + "]";
	}
	
	
	

}
