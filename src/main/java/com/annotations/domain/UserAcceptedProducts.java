package com.annotations.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name = "useracceptedproducts")
public class UserAcceptedProducts {
	
	private int ID;
	private Products product;
	private User user;
	
	
	@Id
    @Column(name = "ID")
    @GeneratedValue
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id")
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
