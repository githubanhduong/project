package com.code.springdemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="no")
		private int no;
	
		@Column(name="category_name")
		private String categoryName;
		
		
		@OneToMany(fetch = FetchType.LAZY)
		@JoinColumn(name="category_no", insertable = true, updatable = true)
		private List<SubCategory> subCategory;
		
		
		public Category() {
			
		}

		public List<SubCategory> getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(List<SubCategory> subCategory) {
			this.subCategory = subCategory;
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
			return "Category [no=" + no + ", categoryName=" + categoryName + ", subCategory=" + subCategory + "]";
		}

		
		
		/*
		 * @Override public String toString() { return "Category [no=" + no +
		 * ", categoryName=" + categoryName + ", subCategory=" + subCategory + "]"; }
		 */

		/*
		 * @Override public String toString() { return "Category [no=" + no +
		 * ", categoryName=" + categoryName + "]"; }
		 */
	
		
			
	
	
}
