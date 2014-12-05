package com.team1.cinemaGo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private long id;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private LocalDateTime orderDate;
	private String barcode;
	private int status;
	
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", client=" + client + ", sessions="
				+ items + ", orderDate=" + orderDate + ", barcode="
				+ barcode + ", status=" + status + "]";
	}
	
	
	
	
}
