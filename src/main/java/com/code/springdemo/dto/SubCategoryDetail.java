package com.code.springdemo.dto;



public class SubCategoryDetail {
	
	private int no;

	private int categoryNo;
	 
	private String subCategoryName;
	
	

	public SubCategoryDetail() {
		
	}

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
		return "SubCategoryDetail [no=" + no + ", categoryNo=" + categoryNo + ", subCategoryName=" + subCategoryName
				+ "]";
	}
	
	
	
}
