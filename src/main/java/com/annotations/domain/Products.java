package com.annotations.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Tables;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue
	private int p_id;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="cost")
	private double cost;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="company")
	private String company;
	
	@Column(name="description")
	private String description;
	
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "[p_id:"+getP_id()+", pname:"+getPname()+", cost:"+getCost()+", discount:"+getDiscount()+", company:"+getCompany()+", description:"+getDescription()+"]";
	}
}
