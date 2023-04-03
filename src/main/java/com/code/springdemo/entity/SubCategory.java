package com.code.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sub_category")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private int no;
	

	@Column(name="category_no") 
	private int categoryNo;
	 
	
	@Column(name="sub_category_name")
	private String subCategoryName;
	
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="category_no",  insertable = false, updatable = false) 
	 private Category category;
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public SubCategory() {
		
	}
	

	/*
	 * public Category getCategory() { return category; }
	 * 
	 * 
	 * public void setCategory(Category category) { this.category = category; }
	 */

	public int getNo() {
		return no;
	}


	public void setNo(int no) { 
		  this.no = no; 
		  }

	 
	public int getCategoryNo() { 
		return categoryNo; 
		}
	
	  
	public void setCategoryNo(int categoryNo) { 
		  this.categoryNo = categoryNo; 
		  }

	 

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}


	@Override
	public String toString() {
		return "SubCategory [no=" + no + ", categoryNo=" + categoryNo + ", subCategoryName=" + subCategoryName
				+ ", category=" + category + "]";
	}


	/*
	 * @Override public String toString() { return "SubCategory [no=" + no +
	 * ", subCategoryName=" + subCategoryName + ", category=" + category + "]"; }
	 */

	
	/*
	 * @Override public String toString() { return "SubCategory [no=" + no +
	 * ", categoryNo=" + categoryNo + ", subCategoryName=" + subCategoryName + "]";
	 * 
	 * }
	 */
	
}
