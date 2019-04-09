package com.ssafy.dao;

import java.util.List;

import com.ssafy.vo.Notice;

public interface NoticeDao {
	List<Notice> searchAll();
	Notice search(String title);
	void registerNotice(String title, String contents);
	void deleteNotice(String title);
}
