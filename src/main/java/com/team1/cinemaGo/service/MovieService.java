package com.team1.cinemaGo.service;

import java.util.List;

import com.team1.cinemaGo.model.Movie;

public interface MovieService {

	public void addMovie(Movie movie);
    public void updateMovie(Movie movie);
    public Movie getMovieById(Integer id);
    public List<Movie> listMovie();
    public void removeMovie(Integer id);	

}
