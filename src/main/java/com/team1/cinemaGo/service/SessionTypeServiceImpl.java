package com.team1.cinemaGo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.team1.cinemaGo.model.SessionType;
import com.team1.cinemaGo.dao.MovieDAO;
import com.team1.cinemaGo.dao.SessionTypeDAO;


@Service("sessionTypeService")
@Transactional
public class SessionTypeServiceImpl implements SessionTypeService {

	@Autowired
	private SessionTypeDAO sessionTypeDAO;


	@Autowired
    @Qualifier("sessionTypeDAO")
	public void setSessionTypeDAO(SessionTypeDAO sessionTypeDAO) {
        this.sessionTypeDAO = sessionTypeDAO;
    }   

	@Override
	@Transactional
	public void addSessionType(SessionType sessionType) {
		sessionTypeDAO.addSessionType(sessionType);
	}

	@Override
	@Transactional
	public void updateSessionType(SessionType sessionType) {
		sessionTypeDAO.updateSessionType(sessionType);
	}

	@Override
	@Transactional
	public SessionType getSessionTypeById(Integer id) {
		return sessionTypeDAO.getSessionTypeById(id);
	}

	@Override
	@Transactional
	public List<SessionType> listSessionType() {
		return sessionTypeDAO.listSessionType();
	}

	@Override
	@Transactional
	public void removeSessionType(Integer id) {
		sessionTypeDAO.removeSessionType(id);
	}

    
}
