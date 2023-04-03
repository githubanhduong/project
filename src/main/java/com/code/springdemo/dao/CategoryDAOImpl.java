package com.code.springdemo.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.SubCategory;


@Repository
public class CategoryDAOImpl implements CategoryDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Category> getcategory() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<Category> theQuery = currentSession.createQuery("from Category",Category.class);
			List<Category> categorys = theQuery.getResultList();
			
			for(int j=0;categorys.size()>j;j++) {
				System.out.println("CategoryNo::::"+categorys.get(j).getNo());
				System.out.println("CategoryName::::"+categorys.get(j).getCategoryName());
			
				for(int i=0;categorys.get(j).getSubCategory().size()>i;i++)
					System.out.println("CategorySubCategoryName::::"+categorys.get(j).getSubCategory().get(i).getSubCategoryName());
			}
			
		
			return categorys;
	}

	@Override
	public List<SubCategory> getSubCategoty() {
		Session currentSession = sessionFactory.getCurrentSession();

		  Query<SubCategory> theQuery =
		  currentSession.createQuery("from SubCategory",SubCategory.class);
		 
		 List<SubCategory> subCategorys =theQuery.getResultList();
		
		
		return subCategorys;
	}
}
