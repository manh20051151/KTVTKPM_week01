package com.example.demo.model;

public class Product {
	private int id;
	private int price;
	
	private User uerUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public User getUerUser() {
		return uerUser;
	}

	public void setUerUser(User uerUser) {
		this.uerUser = uerUser;
	}

	public Product(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	
	
	
}
