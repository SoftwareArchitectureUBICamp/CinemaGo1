package com.team1.cinemaGo.service;

import java.util.List;

import com.team1.cinemaGo.model.SessionType;

public interface SessionTypeService {

	public void addSessionType(SessionType sessionType);
    public void updateSessionType(SessionType sessionType);
    public SessionType getSessionTypeById(Integer id);
    public List<SessionType> listSessionType();
    public void removeSessionType(Integer id);	
	
}
