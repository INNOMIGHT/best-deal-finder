package com.javafourthminiassignment.ebayserver.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class DealCategory {
	
	@Id
	private String category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealCategory")
	@JsonManagedReference
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
