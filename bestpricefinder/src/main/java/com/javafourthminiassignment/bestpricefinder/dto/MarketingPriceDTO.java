package com.javafourthminiassignment.bestpricefinder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketingPriceDTO {
	

	OriginalPrice OriginalPriceObject;
	
	private String discountPercentage;
	
	DiscountAmount DiscountAmountObject;
	
	private String priceTreatment;

	// Getter Methods

	public OriginalPrice getOriginalPrice() {
		return OriginalPriceObject;
	}

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public DiscountAmount getDiscountAmount() {
		return DiscountAmountObject;
	}

	public String getPriceTreatment() {
		return priceTreatment;
	}

	// Setter Methods

	public void setOriginalPrice(OriginalPrice originalPriceObject) {
		this.OriginalPriceObject = originalPriceObject;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public void setDiscountAmount(DiscountAmount discountAmountObject) {
		this.DiscountAmountObject = discountAmountObject;
	}

	public void setPriceTreatment(String priceTreatment) {
		this.priceTreatment = priceTreatment;
	}
}



