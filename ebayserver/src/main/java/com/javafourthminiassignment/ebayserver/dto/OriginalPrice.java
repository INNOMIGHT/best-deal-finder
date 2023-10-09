package com.javafourthminiassignment.ebayserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Embeddable;

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OriginalPrice {
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