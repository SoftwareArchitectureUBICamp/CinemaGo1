package com.team1.cinemaGo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.team1.cinemaGo.model.SessionType;

public class SessionTypeDAOImpl implements SessionTypeDAO {

	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }	

	@Override
	public void addSessionType(SessionType sessionType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sessionType);
	}

	@Override
	public void updateSessionType(SessionType sessionType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sessionType);	
	}

	@Override
	public List<SessionType> listSessionType() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SessionType> sessionTypeList = session.createQuery("from t_session_type").list(); 
		return sessionTypeList;
	}

	@Override
	public SessionType getSessionTypeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (SessionType) session.load(SessionType.class, new Integer(id));
	}

	@Override
	public void removeSessionType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SessionType sessionType = (SessionType) session.load(SessionType.class, new Integer(id));
        if(null != sessionType){
            session.delete(sessionType);
        }
    }

	
}
