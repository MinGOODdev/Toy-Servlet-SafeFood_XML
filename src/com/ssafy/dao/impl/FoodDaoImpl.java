package com.ssafy.dao.impl;

import com.ssafy.dao.FoodDao;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
	private List<Food> foods;

	/**
	 * 싱글톤
	 */
	private static FoodDaoImpl foodDao;
	public static FoodDaoImpl getInstance() {
		if (foodDao == null) foodDao = new FoodDaoImpl();
		return foodDao;
	}

	private FoodDaoImpl() {
		foods = new ArrayList<>();
		loadData();
	}

	/**
	 * 식품 영양학 정보와 식품 정보를 xml 파일에서 읽어온다.
	 */
	private void loadData() {
		FoodSaxParser parser = FoodSaxParser.getInstance();
		foods = parser.getFoods();
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를 검색해서 반환.
	 *
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	@Override
	public List<Food> searchAll(FoodPageBean bean) {
		List<Food> finds = new ArrayList<>();
		if (bean != null) {
            String key = bean.getKey();
            String word = bean.getWord();
            if (!key.equals("all") && word != null && !word.trim().equals("")) {
                switch (key) {
                    case "name":
                        for (Food f : foods) {
                            if (f.getName().contains(word)) finds.add(f);
                        }
                        break;
                    case "maker":
                        for (Food f : foods) {
                            if (f.getMaker().contains(word)) finds.add(f);
                        }
                        break;
                    case "material":
                        for (Food f : foods) {
                            if (f.getMaterial().contains(word)) finds.add(f);
                        }
                        break;
                }
                return finds;
            }else {
            	return foods;
            }
        }
        return finds;
	}

	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
	 *
	 * @param code 검색할 식품 코드
	 * @return 식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	@Override
	public Food search(int code) {
		for (Food food : foods) {
			if (food.getCode() == code) {
				return food;
			}
		}
		return null;
	}
}
