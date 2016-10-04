package com.annotations.dao;

import java.io.Serializable;
import org.hibernate.SQLQuery;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.annotations.controller.DataController;
import com.annotations.domain.Products;
import com.annotations.domain.User;
import com.annotations.domain.UserAcceptedProducts;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int login(String email, String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select count(*) from user where email = '"+email+"' and password = '"+password+"'");
		List i = query.list();
		String k = i.get(0).toString();
		int y = Integer.parseInt(k);
		return y;
	}
	
	@Override
	public String getDesignation() {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select designation from user where email = '"+DataController.email+"'");
		List i = query.list();
		String k = i.get(0).toString();
		return k;
	}
	

	@Override
	@Transactional
	public int insertRow(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(session.isConnected());
		session.saveOrUpdate(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<Products> getProductsList() {
		Session session = sessionFactory.openSession();
		SQLQuery productList = session.createSQLQuery("Select * from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"')"
		+" UNION Select * from Products where p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		@SuppressWarnings("unchecked")
		List<Products> listResult = productList.list();
		return listResult;
	}


	@Override
	public int insertRejectedProducts(int p_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("INSERT INTO rejectedProducts (ID,email,p_id) VALUES (null,"+"'"+DataController.email+"',"+p_id+")");
		query.executeUpdate();
		System.out.println("Query::::"+query);
		tx.commit();
		session.close();
		return p_id;
	}
	
	@Override
	public int insertAcceptedProducts(int p_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("INSERT INTO userAcceptedProducts (ID,email,p_id) VALUES (null,"+"'"+DataController.email+"',"+p_id+")");
		query.executeUpdate();
		System.out.println("Query::::"+query);
		tx.commit();
		session.close();
		return p_id;
	}
	
	@Override
	public List<Products> getRejectedList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "select p.comapany from Products p, UserAcceptedProducts r where p.p_id = r.p_id and r.email ='"+DataController.email+"' order by p.p_id";
		Query query = session.createQuery(hql);
        query.setParameter("email",DataController.email);
        @SuppressWarnings("unchecked")
		List<Products> results = query.list();
		return results;
	}


	@Override
	public List<String> getAcceptedListPname() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.pname from products p, useracceptedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}


	@Override
	public List<Double> getAcceptedListCost() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.cost from products p, useracceptedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<Double> listResult = query.list();
		return listResult;
	}


	@Override
	public List<String> getAcceptedListCompany() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.company from products p, useracceptedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}
	
	@Override
	public List<Integer> getAcceptedListPId() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.p_id from products p, useracceptedproducts r Where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<Integer> listResult = query.list();
		return listResult;
	}
	@Override
	public List<String> getRejectedListPname() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.pname from products p, rejectedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}


	@Override
	public List<Double> getRejectedListCost() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.cost from products p, rejectedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<Double> listResult = query.list();
		return listResult;
	}


	@Override
	public List<Integer> getRejectedListPId() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.p_id from products p, rejectedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<Integer> listResult = query.list();
		return listResult;
	}


	@Override
	public List<String> getRejectedListCompany() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.company from products p, rejectedproducts r where p.p_id = r.p_id and r.email = '"+DataController.email+"' order by p.p_id";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}
	
	@Override
	public List<String> getOrdersListFirstname() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select s.firstname from useracceptedproducts u inner join products p on p.p_id = u.p_id inner join user s on s.email = u.email where p.createdBy = '"+DataController.email+"' order by p.p_id;";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}
	
	@Override
	public List<String> getOrdersListEmail() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select s.email from useracceptedproducts u inner join products p on p.p_id = u.p_id inner join user s on s.email = u.email where p.createdBy = '"+DataController.email+"' order by p.p_id;";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}
	
	@Override
	public List<String> getOrdersListPName() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.pname from useracceptedproducts u inner join products p on p.p_id = u.p_id inner join user s on s.email = u.email where p.createdBy = '"+DataController.email+"' order by p.p_id;";
		SQLQuery query = session.createSQLQuery(hql);
		List<String> listResult = query.list();
		return listResult;
	}
	
	@Override
	public List<Double> getOrdersListCost() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.cost from useracceptedproducts u inner join products p on p.p_id = u.p_id inner join user s on s.email = u.email where p.createdBy = '"+DataController.email+"' order by p.p_id;";
		SQLQuery query = session.createSQLQuery(hql);
		List<Double> listResult = query.list();
		return listResult;
	}
	
	@Override
	public List<Integer> getOrdersListPId() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String hql = "Select p.p_id from useracceptedproducts u inner join products p on p.p_id = u.p_id inner join user s on s.email = u.email where p.createdBy = '"+DataController.email+"' order by p.p_id;";
		SQLQuery query = session.createSQLQuery(hql);
		List<Integer> listResult = query.list();
		return listResult;
	}
	
	@Override
	public void addProduct(Products product) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String pname = product.getPname();
		String company = product.getCompany();
		String description = product.getDescription();
		double cost = product.getCost();
		int discount = product.getDiscount();
		System.out.println("Pname ::::::::::"+pname);
		System.out.println("Company :::::::::"+company);
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("INSERT INTO products (p_id, pname, cost, discount, company, description, createdBy ) VALUES (null,"+"'"+pname+"',"+cost+","+discount+",'"+company+"','"+description+"','"+DataController.email+"')");
		query.executeUpdate();
		System.out.println("Query::::"+query);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<Products> getMyProductsList() {
		Session session = sessionFactory.openSession();
		List<Products> productList = session.createQuery("from Products where createdBy = '"+DataController.email+"'").list();
		return productList;
	}
	
	@Override
	public void deleteMyProduct(int p_id) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("delete from products where p_id = "+p_id);
		query.executeUpdate();
		System.out.println("Query::::"+query);
		tx.commit();
		session.close();		
	}
	
	@Override
	public List<String> getProductPname() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select pname from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<String> listResult = productList.list();
		return listResult;
	}


	@Override
	public List<Double> getProductCost() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select cost from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<Double> listResult = productList.list();
		return listResult;
	}


	@Override
	public List<Integer> getProductPId() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select p_id from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<Integer> listResult = productList.list();
		return listResult;
	}


	@Override
	public List<String> getProductDescription() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select description from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<String> listResult = productList.list();
		return listResult;
	}


	@Override
	public List<String> getProductCompany() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select company from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<String> listResult = productList.list();
		return listResult;
	}


	@Override
	public List<Integer> getProductDiscount() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select discount from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<Integer> listResult = productList.list();
		return listResult;
	}
	
	@Override
	public List<Object[]> getProductsExample() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		SQLQuery productList = session.createSQLQuery("Select p_id, pname, cost, discount, company, description from Products where p_id NOT IN (Select p_id from rejectedproducts where email = '"+DataController.email+"') AND p_id NOT IN (Select p_id from useracceptedproducts where email = '"+DataController.email+"')");
		List<Object[]> listResult = productList.list();
		return listResult;
	}
}
