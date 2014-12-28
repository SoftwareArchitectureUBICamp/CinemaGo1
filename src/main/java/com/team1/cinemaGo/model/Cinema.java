package com.team1.cinemaGo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_cinema")
public class Cinema {
	
	@Id
	@Column(name="cinema_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="cinema_name")	
	private String cinemaName;

	@Column(name="rows_count")	
	private int rowsCount;
	
	@Column(name="columns_count")	
	private int columnsCount;

	public String getCinemaName() {
		return cinemaName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getColumnsCount() {
		return columnsCount;
	}

	public void setColumnsCount(int columnsCount) {
		this.columnsCount = columnsCount;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", cinemaName=" + cinemaName
				+ ", rowsCount=" + rowsCount + ", columnsCount=" + columnsCount
				+ "]";
	}


	
}
