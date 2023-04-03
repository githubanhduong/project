package com.code.springdemo.dto;

public class CategoryDetail {
	private int no;
	private String categoryName;
	
	
	public CategoryDetail() {
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryDetail [no=" + no + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
