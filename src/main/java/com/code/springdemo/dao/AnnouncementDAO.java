package com.code.springdemo.dao;

import java.util.List;

import com.code.springdemo.entity.Announcement;

public interface AnnouncementDAO {

	List<Announcement> getannouncement();

	Announcement getannouncement(int announcementNo);

}
