package com.javafourthminiassignment.amazonserver.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.javafourthminiassignment.amazonserver.dto.Image;
import com.javafourthminiassignment.amazonserver.dto.MarketingPriceDTO;
import com.javafourthminiassignment.amazonserver.dto.PriceDTO;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class DealItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemid;
	
	private String productTitle;
	private String size;
	private String Brand;
	
	@Embedded
	Image ImageObject;
	
	@Embedded
	MarketingPriceDTO MarketingPriceObject;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "pricedto_value")),
        @AttributeOverride(name = "currency", column = @Column(name = "pricedto_currency"))
    })
	PriceDTO PriceObject;
	
	private int stock;
	private Date dealStartDate;
	private Date dealEndDate;
	
	@ManyToOne
    @JoinColumn(name = "deal_category_id")
	@JsonBackReference
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
