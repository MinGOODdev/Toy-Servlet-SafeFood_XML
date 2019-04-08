package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.FoodDao;
import com.ssafy.dao.FoodDaoImpl;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

public class FoodServiceImpl implements FoodService {
	private FoodDaoImpl dao;
	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	/**
	 * 싱글톤
	 */
	private static FoodServiceImpl foodService;
	public static FoodServiceImpl getInstance() {
		if (foodService == null) foodService = new FoodServiceImpl();
		return foodService;
	}

	public FoodServiceImpl() {
		dao = FoodDaoImpl.getInstance();
	}

	public List<Food> searchAll(FoodPageBean bean) {
		return dao.searchAll(bean);
	}

	public Food search(int code) {
		String allergyList = "";
		Food food = dao.search(code);
		for (int i = 0; i < allergys.length; i++) {
			if (food.getMaterial().contains(allergys[i])) {
				allergyList = allergyList + allergys[i] + " ";
			}
		}
		// code에 맞는 식품 정보를 검색하고, 검색된 식품의 원재료에 알레르기 성분이 있는지 확인하여 Food 정보에 입력한다.
		food.setAllergy(allergyList);
		return food;
	}

	public List<Food> searchBest() {
		return dao.searchBest();
	}

	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}
}
