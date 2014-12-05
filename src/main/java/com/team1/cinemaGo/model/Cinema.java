package com.team1.cinemaGo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cinema")
public class Cinema {
	
	private int id;
	private String cinemaName;
	private int seatsNumber;
	
	public String getCinemaName() {
		return cinemaName;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	@Override
	public String toString() {
		return "Cinema [cinemaName=" + cinemaName + ", seatsNumber="
				+ seatsNumber + "]";
	}

	
}
