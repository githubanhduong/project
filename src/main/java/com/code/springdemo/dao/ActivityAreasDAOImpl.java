package com.code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.springdemo.dto.AreasInfoDTO;
import com.code.springdemo.entity.ActivityAreas;



@Repository
public class ActivityAreasDAOImpl implements ActivityAreasDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void addActivityAreas(String customerAddress,int customerNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("SELECT no from AreasInfoVO WHERE "
				+ "CONCAT(sido,sigungu,doro,buildNo1) =:customerAddress");
		theQuery.setParameter("customerAddress",customerAddress.trim().replaceAll(" ",""));
		
		List areasInfo = theQuery.getResultList();
		
		
		ActivityAreas activityAreas = new ActivityAreas();
		activityAreas.setCustoemr_No(customerNo);
		activityAreas.setAreasInfo_No(Integer.parseInt(areasInfo.get(0).toString()));
		
		currentSession.saveOrUpdate(activityAreas);
		
		
	}


	@Override
	public ActivityAreas getActivityAreas(int customer_no) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from ActivityAreas WHERE customer_No = :customer_no",ActivityAreas.class);
		theQuery.setParameter("customer_no",customer_no);
		
		List<ActivityAreas> areasInfo = theQuery.getResultList();
		
		ActivityAreas activityAreas = new ActivityAreas();
		activityAreas.setNo(areasInfo.get(0).getNo());
		activityAreas.setCustoemr_No(areasInfo.get(0).getCustoemr_No());
		activityAreas.setAreasInfo_No(areasInfo.get(0).getAreasInfo_No());
		
		return activityAreas;
	}



	
}
