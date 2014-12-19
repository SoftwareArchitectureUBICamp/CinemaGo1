package com.team1.cinemaGo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="t_seat",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"session_id", "row", "col"})})
public class Seat {
	
	@Id
	@Column(name="seat_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="session_id")
	private MovieSession movieSession;
	
	@Column(name="row")
	private int row;
	
	@Column(name="col")
	private int col;

	public Seat (int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Seat (MovieSession movieSession, int row, int col) {
		this.movieSession = movieSession;
		this.row = row;
		this.col = col;
	}
	
	public MovieSession getMovieSession() {
		return movieSession;
	}

	public void setMovieSession(MovieSession movieSession) {
		this.movieSession = movieSession;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "Seat [session=" + movieSession + ", row=" + row + ", col=" + col
				+ "]";
	}
		


	
	
}
