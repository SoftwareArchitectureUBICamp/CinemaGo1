package com.team1.cinemaGo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.team1.cinemaGo.model.Cinema;

@Repository
public class CinemaDAOImpl implements CinemaDAO {

//    private static final Logger logger = LoggerFactory.getLogger(CinemaDAOImpl.class);
    
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public void addCinema(Cinema cinema) {
		Session session = this.sessionFactory.getCurrentSession();
	    session.persist(cinema);
//	    logger.info("Cinema saved successfully, Cinema Details="+cinema);
	}

	@Override
	public void updateCinema(Cinema cinema) {
		Session session = this.sessionFactory.getCurrentSession();
	    session.update(cinema);
//	    logger.info("Cinema updated successfully, Cinema Details="+cinema);
	}

	@Override
	public List<Cinema> listCinema() {
        Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Cinema> cinemasList = session.createQuery("from Cinema").list();
        for(Cinema cinema : cinemasList){
//            logger.info("Cinemas List::"+cinema);
        }
        return cinemasList;
    }

	@Override
	public Cinema getCinemaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Cinema cinema = (Cinema) session.load(Cinema.class, new Integer(id));
//      logger.info("Cinema loaded successfully, Cinema details="+cinema);
        return cinema;
	}

	@Override
	public void removeCinema(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cinema cinema = (Cinema) session.load(Cinema.class, new Integer(id));
        if(null != cinema){
            session.delete(cinema);
        }
//        logger.info("Cinema deleted successfully, cinema details="+cinema);
	}

}
