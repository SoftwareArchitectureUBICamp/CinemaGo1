package com.team1.cinemaGo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team1.cinemaGo.model.MovieSession;

@Repository("movieSessionDAO")
public class MovieSessionDAOImpl implements MovieSessionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMovieSession(MovieSession movieSession) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(movieSession);
	}

	@Override
	public void updateMovieSession(MovieSession movieSession) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(movieSession);
	}

	@Override
	public List<MovieSession> listMovieSession() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<MovieSession> moviesSessionList = session.createQuery("from MovieSession").list();
//        for(Movie movie : moviesList){
//        	//logging
//        }
        return moviesSessionList;		
	}

	@Override
	public MovieSession getMovieSessionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        MovieSession movieSession = (MovieSession) session.get(MovieSession.class, new Integer(id));
//      logger.info("Cinema loaded successfully, Cinema details="+cinema);
        return movieSession;
	}

	@Override
	public void removeMovieSession(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MovieSession movieSession = (MovieSession) session.get(MovieSession.class, new Integer(id));
        if(null != movieSession){
            session.delete(movieSession);
        }
//        logger.info("Cinema deleted successfully, cinema details="+cinema);
	}

}
