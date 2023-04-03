package com.code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Goods;
import com.code.springdemo.entity.Review;
import com.code.springdemo.service.CustomerService;

@Controller
public class goodsController {

	@Autowired 
	private CustomerService customerService;
	
	@PostMapping("/goodsUpload")
	public String upload(@RequestParam("mainCategory") int category,
			@RequestParam("status") String status,
			@RequestParam("title") String title,
			@RequestParam("price") int price,
			@RequestParam("text") String text,
			@RequestParam("subCategory") int subcategory ,
			Authentication username,
			Model theModel) {
		
		Customer customer = customerService.getCustomersNo(username);
		ActivityAreas activityAreas = customerService.getActivityAreas(customer.getNo());
		
		customerService.addGoods(category,subcategory,status,title,text,price,activityAreas.getAreasInfo_No(),username);
		
		
		return "main-page";
	}
	
	@GetMapping("/detailPage")
	public String detailPage(@RequestParam("goodsNo") int goodsNo,Model theModel) {
		
		Goods goods = customerService.getpage(goodsNo);
		List<Review> reviews = customerService.getReview(goodsNo);
		String customerGoodsId = customerService.getLookup(goods.getSellerNo());
		
		
		theModel.addAttribute("customerId",customerGoodsId);
		theModel.addAttribute("goods",goods);
		theModel.addAttribute("review",reviews);
		
		return "detail-page";
	}
	
	@PostMapping("savereview")
	public String savaRiew(@RequestParam("goodsNo") int goodsNo,
			@RequestParam("review") String review,
			Authentication username,Model theModel) {
		
		customerService.saveReview(goodsNo,username,review);
		
		theModel.addAttribute("goodsNo",goodsNo);
		
		return "redirect:/detailPage";
	}
	
	@GetMapping("deleteGoods")
	public String deleteGoods(@RequestParam("goodsNo")int goodsNo,Model theModel) {
		
			customerService.deleteGoods(goodsNo);
		
		return "redirect:/category";
	}
	
	
}
