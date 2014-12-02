package com.team1.cinemaGo.model;

public class Cinema {
	
	private String cinemaName;
	private int seatsNumber;
	
	public String getCinemaName() {
		return cinemaName;
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
