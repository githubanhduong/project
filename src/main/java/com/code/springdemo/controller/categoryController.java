package com.code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.springdemo.dto.CategoryDetail;
import com.code.springdemo.dto.SubCategoryDetail;
import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Goods;
import com.code.springdemo.entity.SubCategory;
import com.code.springdemo.service.CustomerService;

@Controller
public class categoryController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/category")
	public String category(@RequestParam("subCategoryNo") int subCategoryNo,
			Authentication username,
			Model theModel) {
		
		Customer customer = null;
		ActivityAreas activityAreas = null;
		
		if(username !=null) {
			customer = customerService.getCustomersNo(username);
			activityAreas = customerService.getActivityAreas(customer.getNo());
		}
		 List<Goods> goods = null;  
		 List<Category> categorys = customerService.getcategory(); 
		 List<CategoryDetail> categoryDetail = customerService.getcategoryDetail(categorys);
		 List<SubCategoryDetail> subCategoryDetail = customerService.getSubCategoryDetail(categorys);
		 
		 
		 
		 if(subCategoryNo==0 && activityAreas==null) {
			 goods = customerService.getgoods(); 
		 }else if(subCategoryNo!=0 && activityAreas==null) {
			 goods = customerService.getgoods(subCategoryNo); 
		 }else if(subCategoryNo==0 && activityAreas!=null) {
			 goods = customerService.getgoods(activityAreas);
		 }else if(subCategoryNo!=0 && activityAreas!=null) {
			 goods = customerService.getgoods(subCategoryNo,activityAreas);
		 }
			 
		 theModel.addAttribute("customer", customer);	
		 theModel.addAttribute("category", categoryDetail);
		 theModel.addAttribute("subCategory", subCategoryDetail);
		 theModel.addAttribute("goods",goods); 
		
		return "category-page";
	}
	@GetMapping("/writePost")
	public String writePost(Model theModel) {
		 List<Category> categorys = customerService.getcategory(); 
		 List<CategoryDetail> categoryDetail = customerService.getcategoryDetail(categorys);
		 List<SubCategoryDetail> subCategoryDetail = customerService.getSubCategoryDetail(categorys);
		Goods theGoods = new Goods();
		theModel.addAttribute("goods", theGoods);
		theModel.addAttribute("category", categoryDetail);
		theModel.addAttribute("subCategory", subCategoryDetail);

		
		return "writePost-form";
	}
	
}
