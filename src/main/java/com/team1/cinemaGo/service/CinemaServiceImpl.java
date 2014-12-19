package com.team1.cinemaGo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.cinemaGo.dao.CinemaDAO;
import com.team1.cinemaGo.model.Cinema;

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {


	@Autowired
    private CinemaDAO cinemaDAO;
    
/*    public void setCinemaDAO(CinemaDAO cinemaDAO) {
        this.cinemaDAO = cinemaDAO;
    }*/    
    
	@Override
    @Transactional
	public void addCinema(Cinema cinema) {
    	cinemaDAO.addCinema(cinema);
    }

	@Override
	@Transactional
	public void updateCinema(Cinema cinema) {
    	cinemaDAO.updateCinema(cinema);
    }

	@Override
	@Transactional
	public Cinema getCinemaById(Integer id) {
    	return cinemaDAO.getCinemaById(id);
    }

	@Override
	@Transactional
	public List<Cinema> listCinemas() {
    	return cinemaDAO.listCinema();
    }

	@Override
	@Transactional
	public void removeCinema(Integer id) {
    	cinemaDAO.removeCinema(id);
	}
    
}
