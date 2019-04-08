package com.ssafy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ssafy.vo.Food;

/**
 * FoodNutritionSAXHandler, FoodSAXHandler를 활용하여 식품 정보를 load하는 SAX Parser
 */
public class FoodSaxParser {
    private String nutritionFilePath = "FoodNutritionInfo.xml";
    private String foodFilePath = "foodInfo.xml";
    private List<Food> foods;   // 전체 다 들어있는 데이터

    /**
     * 싱글톤
     */
    public static FoodSaxParser foodSaxParser;
    public static FoodSaxParser getInstance() {
        if (foodSaxParser == null) foodSaxParser = new FoodSaxParser();
        return foodSaxParser;
    }

    private FoodSaxParser() {
        loadData();
    }

    /**
     * FoodNutritionSAXHandler, FoodSAXHandler를 이용 파싱한 식품 정보와 식품 영양 정보를 Food에 병합한다.
     */
    public void loadData() {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            FoodSAXHandler handler = new FoodSAXHandler();
            FoodNutritionSAXHandler nHandler = new FoodNutritionSAXHandler();
            parser.parse(foodFilePath, handler);
            parser.parse(nutritionFilePath, nHandler);
            Map<String, Food> foodMap = handler.getFoods();

            List<Food> temp = new ArrayList<>();
            temp = nHandler.getList();
            Food find = null;

            for (Food food : temp) {
                find = foodMap.get(food.getName());
                if (find != null) {
                    food.setCode(find.getCode());
                    food.setName(find.getName());
                    food.setMaker(find.getMaker());
                    food.setMaterial(find.getMaterial());
                    food.setImg(find.getImg());
                }
                System.out.println(temp);
            }

            setFoods(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized List<Food> getFoods() {
        return foods;
    }

    private synchronized void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
