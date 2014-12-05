package com.team1.cinemaGo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.team1.cinemaGo.model.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {
	
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	public void addMovie(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
	    session.persist(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(movie);
	}

	@Override
	public List<Movie> listMovie() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Movie> moviesList = session.createQuery("from movie").list();
//        for(Movie movie : moviesList){
//        	//logging
//        }
        return moviesList;		
	}

	@Override
	public Movie getMovieById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Movie movie = (Movie) session.load(Movie.class, new Integer(id));
        return movie;
	}

	@Override
	public void removeMovie(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Movie movie = (Movie) session.load(Movie.class, new Integer(id));
        if(null != movie){
            session.delete(movie);
        }
	}

}
