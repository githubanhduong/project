package com.code.springdemo.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;

public class Reviews {
	
	private String customerId;
	
	private String review;
	
	private LocalDateTime created;
	
	

	public Reviews() {
	
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Reviews [customerId=" + customerId + ", review=" + review + ", created=" + created + "]";
	}
	
	
}
