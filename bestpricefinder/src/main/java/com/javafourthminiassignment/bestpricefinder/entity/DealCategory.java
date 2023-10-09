package com.javafourthminiassignment.bestpricefinder.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;



public class DealCategory {

	private String category;
	
	private List<DealItem> dealItems;
	
	public DealCategory(String category, List<DealItem> dealItems) {
		super();
		this.category = category;
		this.dealItems = dealItems;
	}
	
	public DealCategory() {
		super();
	}

	public DealCategory(String category) {
		// TODO Auto-generated constructor stub
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<DealItem> getDealItems() {
		return dealItems;
	}
	public void setDealItems(List<DealItem> dealItems) {
		this.dealItems = dealItems;
	}

	
	
	
	

}
