package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.FoodDao;
import com.ssafy.dao.FoodDaoImpl;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

public class FoodServiceImpl implements FoodService {
	private FoodDaoImpl dao;
	private String[] allergys = { "���몢", "�븙肄�", "�슦�쑀", "寃�", "�깉�슦", "李몄튂", "�뿰�뼱", "�뫁", "�냼怨좉린", "�떗怨좉린", "�뤌吏�怨좉린", "蹂듭댂�븘", "誘쇰뱾�젅",
			"怨꾨��씛�옄" };
	private static FoodServiceImpl instance;
	
	public static FoodServiceImpl getInstance() {
		if(instance==null) instance=new FoodServiceImpl();
		return instance;
		
	}
	
	
	private FoodServiceImpl() {
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
		// code�뿉 留욌뒗 �떇�뭹 �젙蹂대�� 寃��깋�븯怨�, 寃��깋�맂 �떇�뭹�쓽 �썝�옱猷뚯뿉 �븣�젅瑜닿린 �꽦遺꾩씠 �엳�뒗吏� �솗�씤�븯�뿬 Food �젙蹂댁뿉 �엯�젰�븳�떎.
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
