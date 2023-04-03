package com.code.springdemo.dao;

import com.code.springdemo.entity.ActivityAreas;

public interface ActivityAreasDAO {

	void addActivityAreas(String customerAddress,int customerNo);

	ActivityAreas getActivityAreas(int customer_no);

	

}
