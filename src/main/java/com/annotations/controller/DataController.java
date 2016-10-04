package com.annotations.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.annotations.domain.Products;
import com.annotations.domain.User;
import com.annotations.services.DataService;
import com.google.gson.Gson;

@Controller
public class DataController {
	
	@Autowired
	DataService dataService;
	public static String email = "";
	public static String sessionValue = "";
	
	@RequestMapping("home")
	public ModelAndView getHomePage(@ModelAttribute User user) {
		return new ModelAndView("home");
	}
	
	@RequestMapping("form")
	public ModelAndView getFormPage(@ModelAttribute User user) {
		return new ModelAndView("form");
	}
	
	@RequestMapping("register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		int i = dataService.insertRow(user);
		System.out.println("Data inserted into the table");
		return new ModelAndView("redirect:home");
	}
	
	@RequestMapping("createProduct")
	public ModelAndView getCreateProductPage(Model model) {
		Products product = new Products();
	    model.addAttribute("addProduct",product); 
	    return new ModelAndView("createProduct"); 
	}
	
	@RequestMapping("createProductItem")
	public ModelAndView createProductItem(Products product) {
		System.out.println("Create product method");
		dataService.addProduct(product);
	    return new ModelAndView("redirect:createProduct"); 
	}
	
	@RequestMapping("login")
	public ModelAndView login(@ModelAttribute User user, HttpServletRequest request) {
		email = user.getEmail();
		String password = user.getPassword();
		int i = dataService.login(email, password);
		displayLoginPage(request);
		sessionValue = request.getSession().toString();
		if((i == 1)&&(sessionValue!="")){
			String designationName = dataService.getDesignation();
			System.out.println("Designation ::: "+designationName);
			if (designationName.equalsIgnoreCase("Entrepreneur")) {
				return new ModelAndView("redirect:entrepreneurAccount");
			} else {
				return new ModelAndView("redirect:userAccount");
			}
		}else{
			return new ModelAndView("redirect:home");
		}
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		killSession(request);
		return new ModelAndView("redirect:home");
	}
	
	public void displayLoginPage(HttpServletRequest request)
	{
		request.getSession().setAttribute("email", DataController.email);
	}
	
	
	public void killSession(HttpServletRequest request)
	{
		 request.getSession().invalidate();
	}
	
	
	@RequestMapping("userAccount")
	public ModelAndView getHomePage() 
	{
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
		List<String> acceptedListPname = dataService.getProductPname();
		List<Double> acceptedListCost = dataService.getProductCost();
		List<Integer> accepted_p_id = dataService.getProductPId();
		List<String> acceptedListComapny = dataService.getProductCompany();
		List<String> acceptedDescription = dataService.getProductDescription();
		List<Integer> acceptedDiscount= dataService.getProductDiscount();
		System.out.println("Discount :::::"+acceptedDiscount);
		for (int i = 0; i < acceptedListCost.size(); i++) {
			HashMap<String, String> mp = new HashMap<String, String>();
			mp.put("p_id", accepted_p_id.get(i).toString());
			mp.put("pname", acceptedListPname.get(i));
			mp.put("cost", acceptedListCost.get(i).toString());
			mp.put("company", acceptedListComapny.get(i));
			if (acceptedDiscount.get(i) == 0) {
				mp.put("discount", "");
			} else {
				mp.put("discount", acceptedDiscount.get(i).toString());
			}
			mp.put("description", acceptedDescription.get(i));
			System.out.println("Map-------------------->"+mp);
			al.add(mp);
		}
		System.out.println("Array List :   "+al);
		return new ModelAndView("userAccount", "acceptedList", al);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView buyProduct(@ModelAttribute("p_id") int p_id) {
		int i = dataService.insertRejectedProducts(p_id);
		if (i!=0) {
			System.out.println("Data inserted into the rejected table");
		}
		return new ModelAndView("redirect:userDeletedProducts");
	}
	
	@RequestMapping(value = "/deleteMyProduct", method = RequestMethod.GET)
	public ModelAndView deleteMyProduct(@ModelAttribute("p_id") int p_id) {
		dataService.deleteMyProduct(p_id);
		System.out.println("Data deleted from products table");
		return new ModelAndView("redirect:myProducts");
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute("p_id") int p_id) {
		int i = dataService.insertAcceptedProducts(p_id);
		if (i!=0) {
			System.out.println("Data inserted into the accepted table");
		}
		return new ModelAndView("redirect:userOrderedProducts");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("userOrderedProducts")
	public ModelAndView userOrderedProducts() 
	{
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
		List<String> acceptedListPname = dataService.getAcceptedListPname();
		List<Double> acceptedListCost = dataService.getAcceptedListCost();
		List<Integer> accepted_p_id = dataService.getAcceptedListPId();
		List<String> acceptedListComapny = dataService.getAcceptedListCompany();
		for (int i = 0; i < acceptedListCost.size(); i++) {
			HashMap<String, String> mp = new HashMap<String, String>();
			mp.put("p_id", accepted_p_id.get(i).toString());
			mp.put("pname", acceptedListPname.get(i));
			mp.put("cost", acceptedListCost.get(i).toString());
			mp.put("company", acceptedListComapny.get(i));
			al.add(mp);
		}
		System.out.println("Array List :   "+al);
		return new ModelAndView("userOrderedProducts", "acceptedList", al);
	}
	
	@RequestMapping("userDeletedProducts")
	public ModelAndView userDeletedProducts() 
	{
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
		List<String> rejectedListPname = dataService.getRejectedListPname();
		List<Double> rejectedListCost = dataService.getRejectedListCost();
		List<Integer> rejected_p_id = dataService.getRejectedListPId();
		List<String> rejectedListComapny = dataService.getRejectedListCompany();
		for (int i = 0; i < rejectedListCost.size(); i++) {
			HashMap<String, String> mp = new HashMap<String, String>();
			mp.put("p_id", rejected_p_id.get(i).toString());
			mp.put("pname", rejectedListPname.get(i));
			mp.put("cost", rejectedListCost.get(i).toString());
			mp.put("company", rejectedListComapny.get(i));
			al.add(mp);
		}
		System.out.println("Array List :   "+al);
		return new ModelAndView("userDeletedProducts", "rejectedList", al);
	}
	
	@RequestMapping("entrepreneurAccount")
	public ModelAndView getEntrepreneurPage() 
	{
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
		List<String> firstnameList = dataService.getOrdersListFirstname();
		List<String> emailList= dataService.getOrdersListEmail();
		List<String> pNameList= dataService.getOrdersListPName();
		List<Double> costList = dataService.getOrdersListCost();
		List<Integer> p_idList = dataService.getOrdersListPId();
		for (int i = 0; i < costList.size(); i++) {
			HashMap<String, String> mp = new HashMap<String, String>();
			mp.put("p_id", p_idList.get(i).toString());
			mp.put("firstnameList", firstnameList.get(i));
			mp.put("emailList", emailList.get(i).toString());
			mp.put("costList", costList.get(i).toString());
			mp.put("pNameList", pNameList.get(i).toString());
			System.out.println("Map-------------------->"+mp);
			al.add(mp);
		}
		System.out.println("Array List :   "+al);
		String json = new Gson().toJson(al);
		return new ModelAndView("entrepreneurAccount", "orderedList", al);
	}
	
	@RequestMapping("myProducts")
	public ModelAndView getMyProducts() 
	{
		System.out.println("Email : "+email);
		List<Products> myProducts = dataService.getMyProductsList();
		return new ModelAndView("myProducts", "products", myProducts);
	}
	
	@RequestMapping("ajaxCall")
	public String ajaxCall(String email) 
	{
		System.out.println("Email : "+email);
		return email;
	}
	
	@RequestMapping("getProductsExample")
	public ModelAndView getProductsExample() 
	{
		System.out.println("Email : "+email);
		List<Object[]> myProducts = dataService.getProductsExample();
		for (int i = 0; i < myProducts.size(); i++) {
			System.out.println("Object array :::::"+myProducts.get(i));
		}
		return new ModelAndView("myProducts", "products", myProducts);
	}
}
