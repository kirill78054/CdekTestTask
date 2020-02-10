package com.example.cdek.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class OrderClient {

	@Id
    private String id;
	private String title;
	private String address;
	private String status;
	private String date;
	
	public OrderClient() {
	}
	
	public OrderClient(String title, String address) {
		this.title = title;
		this.address = address;
	}
	
	public OrderClient(String id, String title, String address, String date, String status) {
		this.id = id;
		this.title = title;
		this.address = address;
		this.date = date;
		this.status = status;
	}	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		
		return "id равен = " + id + ", название равен = " + title;
	}
	
}
