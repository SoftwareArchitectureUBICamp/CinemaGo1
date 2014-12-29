package com.team1.cinemaGo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.team1.cinemaGo.model.Movie;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {
	
	private SessionFactory sessionFactory;

	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void addMovie(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
	    session.saveOrUpdate(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
	}

	@Override
	public List<Movie> listMovie() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Movie> moviesList = session.createQuery("from Movie ORDER BY movieTitle").list();
//        for(Movie movie : moviesList){
//        	//logging
//        }
        return moviesList;		
	}

	@Override
	public Movie getMovieById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.get(Movie.class, new Long(id));
        return movie;
	}

	@Override
	public void removeMovie(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Movie movie = (Movie) session.get(Movie.class, new Long(id));
        if(null != movie){
            session.delete(movie);
        }
	}

}
