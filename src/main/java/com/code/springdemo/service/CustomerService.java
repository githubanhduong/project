package com.code.springdemo.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.code.springdemo.entity.SubCategory;
import com.code.springdemo.dto.CategoryDetail;
import com.code.springdemo.dto.SubCategoryDetail;
import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Announcement;
import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Goods;
import com.code.springdemo.entity.Review;

public interface CustomerService {

	Customer addCustomer(Customer theCustomer);

	List<Category> getcategory();

	List<Customer> getCustomers();

	List<SubCategory> getSubCategory();	

	List<SubCategoryDetail> getSubCategoryDetail(List<Category> categorys);

	List<CategoryDetail> getcategoryDetail(List<Category> categorys);

	void addGoods(int category, int subcategory, String status, String title, String Description, int price,int activityAreas, Authentication username);

	List<Goods> getgoods();

	Goods getpage(int goodsNo);

	void saveReview(int goodsNo, Authentication username, String review);

	List<Review> getReview(int goodsNo);

	String getLookup(int sellerNo);

	void deleteGoods(int goodsNo);

	List<Goods> getgoods(int subCategoryNo);

	void addActivityAreas(String customerAddress,int customerNo);

	Customer getCustomersNo(Authentication username);

	ActivityAreas getActivityAreas(int customer_no);

	List<Goods> getgoods(ActivityAreas activityAreas);

	List<Goods> getgoods(int subCategoryNo, ActivityAreas activityAreas);

	List<Announcement> getAnnouncement();

	Announcement getAnnouncement(int announcementNo);

	void deleteCustomer(Authentication username);

	

	
	

	
}
