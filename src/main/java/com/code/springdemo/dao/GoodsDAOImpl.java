package com.code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.entity.Goods;
import com.code.springdemo.entity.Review;

@Repository
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addGoods(Goods newGoods) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(newGoods); 
		
	}


	@Override
	public Goods getgoodsdetail(int goodsNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Goods theGoods = currentSession.get(Goods.class, goodsNo);
		return theGoods;
	}

	@Override
	public void saveReview(Review newReview) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(newReview); 
		
	}

	@Override
	public List<Review> getReview(int goodsNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Review> theQuery = currentSession.createQuery("from Review WHERE goodsNo = :No",Review.class);
		theQuery.setParameter("No", goodsNo);
		List<Review> reviews = theQuery.getResultList();
		return reviews;
	}

	@Override
	public void deleteGoods(int goodsNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Goods loadCustomer = currentSession.get(Goods.class, goodsNo);
		currentSession.delete(loadCustomer);
	}
	@Override
	public List<Goods> getgoods() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Goods> theQuery = currentSession.createQuery("from Goods ORDER BY created DESC",Goods.class);
		theQuery.setMaxResults(30);
		List<Goods> goods = theQuery.getResultList();
		
		return goods;
	}
	
	@Override
	public List<Goods> getgoods(int subCategoryNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Goods> theQuery = null;
		List<Goods> goods = null;
		switch(subCategoryNo){
			case 1:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 1);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 12:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 2);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 17:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 3);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 28:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 4);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 37:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 5);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 46:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 6);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 54:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 7);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 66:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 8);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 80:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 9);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			default:
				theQuery = currentSession.createQuery("from Goods WHERE subCategory_no = :category_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", subCategoryNo);
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
		}
		
		
		
		
		return goods;
	}

	@Override
	public List<Goods> getgoods(ActivityAreas activityAreas) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Goods> theQuery = currentSession.createQuery("from Goods WHERE sellingAreaNo= :sellingArea_No ORDER BY created DESC",Goods.class);
		int i = activityAreas.getAreasInfo_No();
		System.out.println(":::::::::::::::::::"+i+":::::::::::::::::::");
		theQuery.setParameter("sellingArea_No",i);
		theQuery.setMaxResults(30);
		List<Goods> goods = theQuery.getResultList();
		
		return goods;
	}

	@Override
	public List<Goods> getgoods(int subCategoryNo, ActivityAreas activityAreas) {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Goods> theQuery = null;
		List<Goods> goods = null;
		switch(subCategoryNo){
			case 1:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 1);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 12:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 2);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 17:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 3);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 28:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 4);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 37:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 5);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 46:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 6);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 54:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 7);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 66:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 8);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			case 80:
				theQuery = currentSession.createQuery("from Goods WHERE categoryNo = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", 9);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
				break;
			default:
				theQuery = currentSession.createQuery("from Goods WHERE subCategory_no = :category_No AND sellingAreaNo = :sellingArea_No ORDER BY created DESC",Goods.class);
				theQuery.setParameter("category_No", subCategoryNo);
				theQuery.setParameter("sellingArea_No", activityAreas.getAreasInfo_No());
				theQuery.setMaxResults(30);
				goods = theQuery.getResultList();
		}
		
		return goods;
	}
}
