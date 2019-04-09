package com.ssafy.service.impl;

import java.util.List;

import com.ssafy.dao.NoticeDao;
import com.ssafy.dao.impl.NoticeDaoImpl;
import com.ssafy.service.NoticeService;
import com.ssafy.vo.Notice;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDao dao;
	
	private static NoticeServiceImpl noticeService;
	public static NoticeServiceImpl getInstance() {
		if(noticeService == null) noticeService = new NoticeServiceImpl();
		return noticeService;
	}
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	@Override
	public List<Notice> searchAll() {
		return dao.searchAll();
	}

	@Override
	public Notice search(String title) {
		return dao.search(title);
	}
	@Override
	public void registerNotice(String title, String contents) {
		dao.registerNotice(title, contents);
	}
	@Override
	public void deleteNotice(String title) {
		dao.deleteNotice(title);
	}

}
