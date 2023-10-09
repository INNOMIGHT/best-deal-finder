package com.javafourthminiassignment.ebayserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketingPriceDTO {
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "original_price_value")),
        @AttributeOverride(name = "currency", column = @Column(name = "original_price_currency"))
    })
	OriginalPrice OriginalPriceObject;
	
	private String discountPercentage;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "discount_amount_value")),
        @AttributeOverride(name = "currency", column = @Column(name = "discount_amount_currency"))
    })
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



