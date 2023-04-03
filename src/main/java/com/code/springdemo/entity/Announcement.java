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
@Table(name="announcement")
public class Announcement {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="no")
		private int no;
	
		@Column(name="title")
		private String title;
		
		@Column(name="text")
		private String text;

		@Column(name="created")
		@CreationTimestamp
		private LocalDateTime created;
		

		public Announcement() {
			
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public LocalDateTime getCreated() {
			return created;
		}

		public void setCreated(LocalDateTime created) {
			this.created = created;
		}

		@Override
		public String toString() {
			return "announcement [no=" + no + ", title=" + title + ", text=" + text + ", created=" + created + "]";
		}
		
		
		
}