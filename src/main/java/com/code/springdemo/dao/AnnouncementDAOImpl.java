package com.code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.springdemo.entity.Announcement;
import com.code.springdemo.entity.Category;
import com.code.springdemo.entity.Customer;

@Repository
public class AnnouncementDAOImpl implements AnnouncementDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Announcement> getannouncement() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Announcement> theQuery = currentSession.createQuery("from Announcement",Announcement.class);
		List<Announcement> announcement = theQuery.getResultList();
		
		return announcement;
	}

	@Override
	public Announcement getannouncement(int announcementNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Announcement announcement = currentSession.get(Announcement.class, announcementNo);
		
		return announcement;
	}
}
