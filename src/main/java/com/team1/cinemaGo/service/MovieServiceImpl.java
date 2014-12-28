package com.team1.cinemaGo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.team1.cinemaGo.dao.MovieDAO;
import com.team1.cinemaGo.model.Movie;


@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService{

	private MovieDAO movieDAO;
	
	@Autowired
    @Qualifier("movieDAO")
	public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }    
    
	@Override
    @Transactional
	public void addMovie(Movie movie) {
    	movieDAO.addMovie(movie);
    }

	@Override
    @Transactional
	public void updateMovie(Movie movie) {
		movieDAO.updateMovie(movie);
	}

	@Override
    @Transactional
	public Movie getMovieById(Long id) {
		return movieDAO.getMovieById(id);
	}

	@Override
    @Transactional
	public List<Movie> listMovie() {
		return movieDAO.listMovie();
	}

	@Override
    @Transactional
	public void removeMovie(Long id) {
		movieDAO.removeMovie(id);
	}

}
