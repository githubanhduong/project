package com.code.springdemo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="goods")
public class Goods {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private int no;
	
	
	
	@Column(name="seller_no")
	private int sellerNo;
	
	@Column(name="category_no")
	private int categoryNo;
	
	@Column(name="subcategory_no")
	private int subCategory_no;
	
	@Column(name="selling_area_no")
	private int sellingAreaNo;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private int price;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="created")
	@CreationTimestamp
	private LocalDateTime created;
	
	@Column(name="status")
	private String status;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="no") private Customer customer;
	 */

	public Goods() {
		
	}

	
	
	public int getSellingAreaNo() {
		return sellingAreaNo;
	}



	public void setSellingAreaNo(int sellingAreaNo) {
		this.sellingAreaNo = sellingAreaNo;
	}



	public int getSubCategory_no() {
		return subCategory_no;
	}



	public void setSubCategory_no(int subCategory_no) {
		this.subCategory_no = subCategory_no;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Goods [no=" + no + ", sellerNo=" + sellerNo + ", categoryNo=" + categoryNo + ", subCategory_no="
				+ subCategory_no + ", sellingAreaNo=" + sellingAreaNo + ", title=" + title + ", price=" + price
				+ ", description=" + description + ", created=" + created + ", status=" + status + "]";
	}





	
	
	

}
