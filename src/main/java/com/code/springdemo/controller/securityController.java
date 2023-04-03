package com.code.springdemo.controller;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.code.springdemo.entity.Announcement;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.service.CustomerService;

@Controller
public class securityController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/")
	public String listCustomers(Model theModel) {

		return "main-page";
	}
	
	
	
	@GetMapping("/announcement")
	public String announcement(Model theModel) {
		
		List<Announcement> announcement = customerService.getAnnouncement();
		
		theModel.addAttribute("announcement",announcement);
		
		return "announcement-page";
	}
	
	@GetMapping("/announcementdetail")
	public String announcementdetail(@RequestParam("announcementNo") int announcementNo,Model theModel) {
		
		Announcement announcement = customerService.getAnnouncement(announcementNo);
		
		theModel.addAttribute("announcement",announcement);
		
		return "announcementdetail-page";
	}
	@GetMapping("/showMyLoginPage") 
	  public String mylogin() {
	  //return "plain-login";
		return "login-form"; 
	  }
	@GetMapping("/acess-denied")
	 public String acess() {
		return "main-page";
	}
	@GetMapping("signUp")
	public String signUp(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "signUp-form";
	}
	@GetMapping("/sample")
	public String a() {
		return "sample";
	}
	
	
	@PostMapping("/exUploadPost")
	public String exUpload(MultipartFile file) {
		File saveFile = new File("c\\ftmp\\storage",file.getOriginalFilename());
		
			try {
				file.transferTo(saveFile);
			}catch(Exception e) {
				e.printStackTrace();
			}
	return "main-page";
	}
}










