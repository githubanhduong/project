package com.code.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.service.CustomerService;

@Controller
public class custoemrController {
	
	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/SignUpCustomer")
	public String SignUpCustomer(@ModelAttribute("customer") Customer theCustomer, Model theModel) {
		Customer customers = customerService.addCustomer(theCustomer);
		
		
		theModel.addAttribute("customerAddress",customers.getCustomerAddress());
		theModel.addAttribute("customerNo",customers.getNo());
		
		return "redirect:/addActivityAreas";
	}
	
	@GetMapping("/addActivityAreas")
	public String addActivityAreas(@RequestParam("customerAddress") String thecustomerAddress,
			@RequestParam("customerNo") int thecustomerNo
			,Model theModel) {
		
		customerService.addActivityAreas(thecustomerAddress,thecustomerNo);
		
		
		return "main-page";
	}
	
	@GetMapping("/my")
	public String mypage(Authentication username,Model theModel) {
		Customer customer = customerService.getCustomersNo(username);
		theModel.addAttribute("customer",customer);
		
		return "mypage";
	}
	
	@GetMapping("/myUpdate")
	public String myUpdate(Authentication username,Model theModel) {
		Customer customer = customerService.getCustomersNo(username);
		theModel.addAttribute("customer",customer);
		
		return "signUp-form";
	}
	
	@GetMapping("/mydelete")
	public String mydelete(Authentication username,Model theModel) {
		customerService.deleteCustomer(username);
		SecurityContextHolder.clearContext();
		return "redirect:/";
	}
	
}
