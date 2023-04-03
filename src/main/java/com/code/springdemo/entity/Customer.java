package com.code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private int no;
	
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="customer_pw")
	private String customerPw;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_role")
	private String customerRole;

	@Column(name="customer_address")
	private String customerAddress;
	
	@Column(name="customer_address_detail")
	private String customerAddressDetail;

	@Column(name="customer_phone")
	private String customerPhone;
	
	@Column(name="customer_activated")
	private boolean customerActivated;
	
	public Customer() {
		
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	

	public String getCustomerAddressDetail() {
		return customerAddressDetail;
	}


	public void setCustomerAddressDetail(String customerAddressDetail) {
		this.customerAddressDetail = customerAddressDetail;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public boolean getCustomerActivated() {
		return customerActivated;
	}

	public void setCustomerActivated(boolean customerActivated) {
		this.customerActivated = customerActivated;
	}


	@Override
	public String toString() {
		return "Customer [no=" + no + ", customerId=" + customerId + ", customerPw=" + customerPw + ", customerName="
				+ customerName + ", customerRole=" + customerRole + ", customerAddress=" + customerAddress
				+ ", customerAddressDetail=" + customerAddressDetail + ", customerPhone=" + customerPhone
				+ ", customerActivated=" + customerActivated + "]";
	}
	
	


		
}





