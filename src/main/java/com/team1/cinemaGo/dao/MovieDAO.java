package com.team1.cinemaGo.dao;

import java.util.List;

import com.team1.cinemaGo.model.Movie;

public interface MovieDAO {

    public void addMovie(Movie movie);
    public void updateMovie(Movie movie);
    public List<Movie> listMovie();
    public Movie getMovieById(int id);
    public void removeMovie(int id);

}
