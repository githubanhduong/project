package com.code.springdemo.dao;

import java.util.List;

import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.SubCategory;

public interface CategoryDAO 
{

	List<Category> getcategory();

	List<SubCategory> getSubCategoty();

	

}
