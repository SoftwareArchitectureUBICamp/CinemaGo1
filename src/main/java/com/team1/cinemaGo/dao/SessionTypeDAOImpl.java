package com.team1.cinemaGo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.team1.cinemaGo.model.SessionType;

@Repository("sessionTypeDAO")
public class SessionTypeDAOImpl implements SessionTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addSessionType(SessionType sessionType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(sessionType);
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
		List<SessionType> sessionTypeList = session.createQuery("from SessionType").list(); 
		return sessionTypeList;
	}

	@Override
	public SessionType getSessionTypeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (SessionType) session.get(SessionType.class, new Integer(id));
	}

	@Override
	public void removeSessionType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SessionType sessionType = (SessionType) session.get(SessionType.class, new Integer(id));
        if(null != sessionType){
            session.delete(sessionType);
        }
    }

	
}
