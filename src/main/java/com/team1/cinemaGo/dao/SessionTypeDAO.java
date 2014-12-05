package com.team1.cinemaGo.dao;

import java.util.List;

import com.team1.cinemaGo.model.SessionType;

public interface SessionTypeDAO {

    public void addSessionType(SessionType sessionType);
    public void updateSessionType(SessionType sessionType);
    public List<SessionType> listSessionType();
    public SessionType getSessionTypeById(int id);
    public void removeSessionType(int id);
	
}
