package com.team1.cinemaGo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_movie")
public class Movie {
	
	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="movie_title")
	private String movieTitle;
	
	@Column(name="movie_duration")
	private int duration;
	
	@Column(name="movie_description")
	private String description;
	
	
	public String getMovieTitle() {
		return movieTitle;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
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
