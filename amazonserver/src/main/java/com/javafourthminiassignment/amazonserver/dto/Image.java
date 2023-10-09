package com.javafourthminiassignment.amazonserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {


	private String imageUrl;

	// Getter Methods

	public String getImageUrl() {
		return imageUrl;
	}

	// Setter Methods

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
