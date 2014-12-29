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
		session.saveOrUpdate(movieSession);
	}

	@Override
	public void updateMovieSession(MovieSession movieSession) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(movieSession);
	}

	@Override
	public List<MovieSession> listMovieSession() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<MovieSession> moviesSessionList = session.createQuery("FROM MovieSession ORDER BY startTime, cinema").list();
//        for(Movie movie : moviesList){
//        	//logging
//        }
        return moviesSessionList;		
	}

	@Override
	public MovieSession getMovieSessionById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        MovieSession movieSession = (MovieSession) session.get(MovieSession.class, new Long(id));
//      logger.info("Cinema loaded successfully, Cinema details="+cinema);
        return movieSession;
	}

	@Override
	public void removeMovieSession(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        MovieSession movieSession = (MovieSession) session.get(MovieSession.class, new Long(id));
        if(null != movieSession){
            session.delete(movieSession);
        }
//        logger.info("Cinema deleted successfully, cinema details="+cinema);
	}

}
