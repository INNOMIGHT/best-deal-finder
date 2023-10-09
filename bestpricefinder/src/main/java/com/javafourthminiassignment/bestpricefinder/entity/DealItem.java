package com.javafourthminiassignment.bestpricefinder.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.javafourthminiassignment.bestpricefinder.dto.Image;
import com.javafourthminiassignment.bestpricefinder.dto.MarketingPriceDTO;
import com.javafourthminiassignment.bestpricefinder.dto.PriceDTO;



public class DealItem {
	

	private Long itemid;
	
	private String productTitle;
	private String size;
	private String Brand;

	Image ImageObject;

	MarketingPriceDTO MarketingPriceObject;

	PriceDTO PriceObject;
	
	private int stock;
	private Date dealStartDate;
	private Date dealEndDate;

    private DealCategory dealCategory;
	
	
	public DealCategory getDealCategory() {
		return dealCategory;
	}

	public void setDealCategory(DealCategory dealCategory) {
		this.dealCategory = dealCategory;
	}

	public DealItem(String productTitle, String size, String brand, Image imageObject,
			MarketingPriceDTO marketingPriceObject, PriceDTO priceObject, int stock, Date dealStartDate,
			Date dealEndDate) {
		super();
		this.productTitle = productTitle;
		this.size = size;
		Brand = brand;
		ImageObject = imageObject;
		MarketingPriceObject = marketingPriceObject;
		PriceObject = priceObject;
		this.stock = stock;
		this.dealStartDate = dealStartDate;
		this.dealEndDate = dealEndDate;
	}

	public DealItem() {
		// TODO Auto-generated constructor stub
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Image getImageObject() {
		return ImageObject;
	}

	public void setImageObject(Image imageObject) {
		ImageObject = imageObject;
	}

	public MarketingPriceDTO getMarketingPriceObject() {
		return MarketingPriceObject;
	}

	public void setMarketingPriceObject(MarketingPriceDTO marketingPriceObject) {
		MarketingPriceObject = marketingPriceObject;
	}

	public PriceDTO getPriceObject() {
		return PriceObject;
	}

	public void setPriceObject(PriceDTO priceObject) {
		PriceObject = priceObject;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getDealStartDate() {
		return dealStartDate;
	}

	public void setDealStartDate(Date dealStartDate) {
		this.dealStartDate = dealStartDate;
	}

	public Date getDealEndDate() {
		return dealEndDate;
	}

	public void setDealEndDate(Date dealEndDate) {
		this.dealEndDate = dealEndDate;
	}
	
}
