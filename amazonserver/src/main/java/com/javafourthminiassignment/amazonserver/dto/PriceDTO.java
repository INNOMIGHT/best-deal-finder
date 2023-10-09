package com.javafourthminiassignment.amazonserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO {
	
	
	private String value;
	
	private String currency;

	// Getter Methods

	public String getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	// Setter Methods

	public void setValue(String value) {
		this.value = value;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
