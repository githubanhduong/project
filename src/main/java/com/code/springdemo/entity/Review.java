package com.code.springdemo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="review")
public class Review {
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="no")
			private int no;
		
			@Column(name="buyer_no")
			private int buyerNo;
			
			@Column(name="goods_no")
			private int goodsNo;
			
			@Column(name="review")
			private String review;
			
			@Column(name="created")
			@CreationTimestamp
			private LocalDateTime created;
			
			
			public Review() {
				
			}

			public int getNo() {
				return no;
			}

			public void setNo(int no) {
				this.no = no;
			}

			public int getBuyerNo() {
				return buyerNo;
			}

			public void setBuyerNo(int buyerNo) {
				this.buyerNo = buyerNo;
			}

			public int getGoodsNo() {
				return goodsNo;
			}

			public void setGoodsNo(int goodsNo) {
				this.goodsNo = goodsNo;
			}

			public String getReview() {
				return review;
			}

			public void setReview(String review) {
				this.review = review;
			}

			public LocalDateTime getCreated() {
				return created;
			}

			public void setCreated(LocalDateTime created) {
				this.created = created;
			}

			@Override
			public String toString() {
				return "Review [no=" + no + ", buyerNo=" + buyerNo + ", goodsNo=" + goodsNo + ", review=" + review
						+ ", created=" + created + "]";
			}
			
			
			
			

}
