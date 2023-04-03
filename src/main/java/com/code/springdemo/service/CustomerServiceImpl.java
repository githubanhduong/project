package com.code.springdemo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.springdemo.dao.ActivityAreasDAO;
import com.code.springdemo.dao.ActivityAreasDAOImpl;
import com.code.springdemo.dao.AnnouncementDAO;
import com.code.springdemo.dao.CategoryDAO;
import com.code.springdemo.dao.CustomerDAO;
import com.code.springdemo.dao.GoodsDAO;
import com.code.springdemo.dto.CategoryDetail;
import com.code.springdemo.dto.SubCategoryDetail;
import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Announcement;
import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Goods;
import com.code.springdemo.entity.Review;
import com.code.springdemo.entity.SubCategory;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private GoodsDAO goodsDAO;
	
	@Autowired
	private ActivityAreasDAO activity_areasDAO;
	
	@Autowired
	private AnnouncementDAO announcementDAO;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Customer addCustomer(Customer theCustomer) {
		String encodePassword = passwordEncoder.encode(theCustomer.getCustomerPw());
		theCustomer.setCustomerPw(encodePassword);
		return customerDAO.addCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public List<Category> getcategory() {
		List<Category> categorys = categoryDAO.getcategory();
		
		/*
		 * for(int j=0;categorys.size()>j;j++) {
		 * System.out.println("CategoryNo::::"+categorys.get(j).getNo());
		 * System.out.println("CategoryName::::"+categorys.get(j).getCategoryName());
		 * 
		 * for(int i=0;categorys.get(j).getSubCategory().size()>i;i++)
		 * System.out.println("CategorySubCategoryName::::"+categorys.get(j).
		 * getSubCategory().get(i).getSubCategoryName()); }
		 */
		return categorys;
	}
	@Override
	@Transactional
	public List<SubCategory> getSubCategory(){
		
		
		
		return categoryDAO.getSubCategoty();
	}
	
	
	@Override
	@Transactional
	public List<CategoryDetail> getcategoryDetail(List<Category> categorys) {
		List<CategoryDetail> categorysDetail = new ArrayList<CategoryDetail>();
		for(int i=0;categorys.size()>i;i++) {
			CategoryDetail a = new CategoryDetail();
			a.setNo(categorys.get(i).getNo());
			a.setCategoryName(categorys.get(i).getCategoryName());
			
			categorysDetail.add(a);
		}
	
		return categorysDetail;
	}
	
	
	@Override
	@Transactional
	public List<SubCategoryDetail> getSubCategoryDetail(List<Category> categorys){
		List<SubCategoryDetail> subCategoryDetail= new ArrayList<SubCategoryDetail>();
			for(int i=0;categorys.size()>i;i++) {
				for(int j=0;categorys.get(i).getSubCategory().size()>j;j++) {
				SubCategoryDetail a = new SubCategoryDetail();
				
				a.setNo(categorys.get(i).getSubCategory().get(j).getNo());
				a.setCategoryNo(categorys.get(i).getSubCategory().get(j).getCategoryNo());
				a.setSubCategoryName(categorys.get(i).getSubCategory().get(j).getSubCategoryName());
				
				subCategoryDetail.add(a);
				}
		}
		return subCategoryDetail;
	}


	@Override
	@Transactional
	public void addGoods(int category, int subcategory, String status, String title,
			String Description, int price, int activityAreas, Authentication username) {
		
		Customer seller_no = customerDAO.getLookup(username.getName());
		
		
		  Goods newGoods = new Goods(); 
		  newGoods.setSellerNo(seller_no.getNo());
		  newGoods.setStatus(status); 
		  newGoods.setCategoryNo(category);
		  newGoods.setSubCategory_no(subcategory);
		  newGoods.setDescription(Description); 
		  newGoods.setPrice(price);
		 newGoods.setTitle(title); 
		 newGoods.setSellingAreaNo(activityAreas);
		 
		  
		 goodsDAO.addGoods(newGoods);
		 
		
		
	}
	



	@Override
	@Transactional
	public Goods getpage(int goodsNo) {
		
		
		return goodsDAO.getgoodsdetail(goodsNo);
	}

	@Override
	@Transactional
	public void saveReview(int goodsNo, Authentication username,String review) {
		
		Customer buyer_no = customerDAO.getLookup(username.getName());
		
		Review newReview = new Review();
		newReview.setBuyerNo(buyer_no.getNo());
		newReview.setGoodsNo(goodsNo);
		newReview.setReview(review);
		
		goodsDAO.saveReview(newReview);
		
		
	}

	@Override
	@Transactional
	public List<Review> getReview(int goodsNo) {
		
		return goodsDAO.getReview(goodsNo);
	}

	@Override
	@Transactional
	public String getLookup(int sellerNo) {
		
		return customerDAO.getLookup(sellerNo);
	}

	@Override
	@Transactional
	public void deleteGoods(int goodsNo) {
		
		goodsDAO.deleteGoods(goodsNo);
	}

	@Override
	@Transactional
	public void addActivityAreas(String customerAddress,int customerNo) {
		 activity_areasDAO.addActivityAreas(customerAddress,customerNo);
		
	}

	@Override
	@Transactional
	public Customer getCustomersNo(Authentication username) {
		Customer customer_no = customerDAO.getLookup(username.getName());
		return customer_no;
	}

	@Override
	@Transactional
	public ActivityAreas getActivityAreas(int customer_no) {
		
		return activity_areasDAO.getActivityAreas(customer_no);
	}
	
	@Override
	@Transactional
	public List<Goods> getgoods() {
		
		return goodsDAO.getgoods();
	}
	
	@Override
	@Transactional
	public List<Goods> getgoods(int subCategoryNo) {
		
		return  goodsDAO.getgoods(subCategoryNo);
	}
	

	@Override
	@Transactional
	public List<Goods> getgoods(ActivityAreas activityAreas) {
		
		return goodsDAO.getgoods(activityAreas);
	}

	@Override
	@Transactional
	public List<Goods> getgoods(int subCategoryNo, ActivityAreas activityAreas) {
		
		return goodsDAO.getgoods(subCategoryNo,activityAreas);
	}

	@Override
	@Transactional
	public List<Announcement> getAnnouncement() {
		
		return announcementDAO.getannouncement();
	}

	@Override
	@Transactional
	public Announcement getAnnouncement(int announcementNo) {
		
		return announcementDAO.getannouncement(announcementNo);
	}

	@Override
	@Transactional
	public void deleteCustomer(Authentication username) {
		customerDAO.deleteCustomer(username.getName());
		
	}

	

	
	
}





