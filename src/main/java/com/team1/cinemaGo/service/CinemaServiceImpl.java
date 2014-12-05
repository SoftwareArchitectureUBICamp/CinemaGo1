package com.team1.cinemaGo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.team1.cinemaGo.dao.CinemaDAO;
import com.team1.cinemaGo.model.Cinema;

@Service
public class CinemaServiceImpl implements CinemaService {


    private CinemaDAO cinemaDAO;
    
    public void setCinemaDAO(CinemaDAO cinemaDAO) {
        this.cinemaDAO = cinemaDAO;
    }    
    
    @Transactional
	public void addCinema(Cinema cinema) {
    	cinemaDAO.addCinema(cinema);
    }

    @Transactional
	public void updateCinema(Cinema cinema) {
    	cinemaDAO.updateCinema(cinema);
    }

    @Transactional
	public Cinema getCinemaById(Integer id) {
    	return cinemaDAO.getCinemaById(id);
    }

    @Transactional
	public List<Cinema> listCinemas() {
    	return cinemaDAO.listCinema();
    }

    @Transactional
	public void removeCinema(Integer id) {
    	cinemaDAO.removeCinema(id);
	}
    
}
