package com.code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activity_areas")
public class ActivityAreas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private int no;

	
	@Column(name="customer_no")
	private int customer_No;
	
	@Column(name="areasinfo_no")
	private int areasInfo_No;

	
	public ActivityAreas() {
		
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getCustoemr_No() {
		return customer_No;
	}


	public void setCustoemr_No(int custoemr_No) {
		this.customer_No = custoemr_No;
	}


	public int getAreasInfo_No() {
		return areasInfo_No;
	}


	public void setAreasInfo_No(int areasInfo_No) {
		this.areasInfo_No = areasInfo_No;
	}


	@Override
	public String toString() {
		return "ActivityAreas [no=" + no + ", custoemr_No=" + customer_No + ", areasInfo_No=" + areasInfo_No + "]";
	}


	
	
}
