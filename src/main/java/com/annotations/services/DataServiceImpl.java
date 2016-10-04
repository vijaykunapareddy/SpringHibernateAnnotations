package com.annotations.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.annotations.dao.DataDao;
import com.annotations.domain.Products;
import com.annotations.domain.User;

public class DataServiceImpl implements DataService {
	
	@Autowired
	DataDao dataDao;

	@Override
	public int insertRow(User employee) {
		return dataDao.insertRow(employee);
	}
	
	@Override
	public int login(String email, String password) {
		return dataDao.login(email, password);
	}

	@Override
	public List<Products> getProductsList() {
		return dataDao.getProductsList();
	}

	@Override
	public int insertRejectedProducts(int p_id) {
		return dataDao.insertRejectedProducts(p_id);
	}

	@Override
	public int insertAcceptedProducts(int p_id) {
		return dataDao.insertAcceptedProducts(p_id);
	}

	@Override
	public List<Products> getRejectedList() {
		return dataDao.getRejectedList();
	}

	@Override
	public List<String> getAcceptedListPname() {
		return dataDao.getAcceptedListPname();
	}

	@Override
	public List<Double> getAcceptedListCost() {
		return dataDao.getAcceptedListCost();
	}

	@Override
	public List<String> getAcceptedListCompany() {
		return dataDao.getAcceptedListCompany();
	}
	
	@Override
	public List<Integer> getAcceptedListPId() {
		return dataDao.getAcceptedListPId();
	}
	
	@Override
	public List<String> getRejectedListPname() {
		return dataDao.getRejectedListPname();
	}

	@Override
	public List<Double> getRejectedListCost() {
		return dataDao.getRejectedListCost();
	}

	@Override
	public List<Integer> getRejectedListPId() {
		return dataDao.getRejectedListPId();
	}

	@Override
	public List<String> getRejectedListCompany() {
		return dataDao.getRejectedListCompany();
	}
	
	@Override
	public String getDesignation() {
		return dataDao.getDesignation();
	}
	
	@Override
	public List<String> getOrdersListFirstname() {
		return dataDao.getOrdersListFirstname();
	}
	
	@Override
	public List<String> getOrdersListEmail() {
		return dataDao.getOrdersListEmail();
	}
	
	@Override
	public List<String> getOrdersListPName() {
		return dataDao.getOrdersListPName();
	}

	@Override
	public List<Double> getOrdersListCost() {
		return dataDao.getOrdersListCost();
	}

	@Override
	public List<Integer> getOrdersListPId() {
		return dataDao.getOrdersListPId();
	}
	
	@Override
	public void addProduct(Products product) {
		dataDao.addProduct(product);
	}
	
	@Override
	public List<Products> getMyProductsList() {
		return dataDao.getMyProductsList();
	}
	
	@Override
	public void deleteMyProduct(int p_id) {
		dataDao.deleteMyProduct(p_id);
	}
	
	@Override
	public List<String> getProductPname() {
		return dataDao.getProductPname();
	}

	@Override
	public List<Double> getProductCost() {
		return dataDao.getProductCost();
	}

	@Override
	public List<Integer> getProductPId() {
		return dataDao.getProductPId();
	}

	@Override
	public List<String> getProductDescription() {
		return dataDao.getProductDescription();
	}

	@Override
	public List<String> getProductCompany() {
		return dataDao.getProductCompany();
	}

	@Override
	public List<Integer> getProductDiscount() {
		return dataDao.getProductDiscount();
	}
	
	@Override
	public List<Object[]> getProductsExample() {
		return dataDao.getProductsExample();
	}
}
