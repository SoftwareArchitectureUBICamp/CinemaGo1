package com.team1.cinemaGo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_session_type")
public class SessionType {

	@Id
	@Column(name="session_type_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="session_name")
	private String sessionName;
	
	@Column(name="session_price")
	private BigDecimal sessionPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public BigDecimal getSessionPrice() {
		return sessionPrice;
	}

	public void setSessionPrice(BigDecimal sessionPrice) {
		this.sessionPrice = sessionPrice;
	}

	@Override
	public String toString() {
		return "SessionType [id=" + id + ", sessionName=" + sessionName
				+ ", sessionPrice=" + sessionPrice + "]";
	}

}

