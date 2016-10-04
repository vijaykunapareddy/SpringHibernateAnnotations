package com.annotations.dao;

import java.util.List;

import com.annotations.domain.Products;
import com.annotations.domain.User;

public interface DataDao {
	
	public int insertRow(User user);
	
	public String getDesignation();

	public int login(String email, String password);

	public List<Products> getProductsList();

	public int insertRejectedProducts(int p_id);
	
	public int insertAcceptedProducts(int p_id);
	
	public List<Products> getRejectedList();

	public List<String> getAcceptedListPname();

	public List<Double> getAcceptedListCost();

	public List<String> getAcceptedListCompany();
	
	public List<Integer> getAcceptedListPId();
	
	public List<String> getRejectedListPname();

	public List<Double> getRejectedListCost();

	public List<Integer> getRejectedListPId();

	public List<String> getRejectedListCompany();
	
	public List<String> getOrdersListFirstname();

	public List<String> getOrdersListEmail();

	public List<String> getOrdersListPName();

	public List<Double> getOrdersListCost();

	public List<Integer> getOrdersListPId();
	
	public void addProduct(Products product);
	
	public List<Products> getMyProductsList();
	
	public void deleteMyProduct(int p_id);
	
	public List<String> getProductPname();

	public List<Double> getProductCost();

	public List<Integer> getProductPId();

	public List<String> getProductDescription();

	public List<String> getProductCompany();

	public List<Integer> getProductDiscount();
	
	public List<Object[]> getProductsExample();

}
