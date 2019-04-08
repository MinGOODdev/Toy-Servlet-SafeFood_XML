package com.ssafy.controller;

import com.ssafy.service.FoodServiceImpl;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FoodController {
    private FoodServiceImpl foodService = FoodServiceImpl.getInstance();

    private static FoodController foodController;
    public static FoodController getInstance() {
        if (foodController == null) foodController = new FoodController();
        return foodController;
    }

    /**
     * 모든 식품 조회
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo getFoodList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("foods", foodService.searchAll(new FoodPageBean()));
//        System.out.println(foodService.searchAll(new FoodPageBean()));
        return new PageInfo(true, "WEB-INF/food/list.jsp");
    }

    /**
     * 식품 상세 조회
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo getFoodDetail(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        Food food = foodService.search(Integer.parseInt(code));
        request.setAttribute("food", food);
        return new PageInfo(true, "WEB-INF/food/view.jsp");
    }

    /**
     * 검색 기준에 따른 검색
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo searchBy(HttpServletRequest request, HttpServletResponse response) {
        String sb = request.getParameter("sb");
        String st = request.getParameter("st");

        switch (sb) {
            case "code":
                List<Food> temp1 = new ArrayList<>();
                Food food = foodService.search(Integer.parseInt(st));
                temp1.add(food);
                request.setAttribute("foods", temp1);
                break;
            case "name":
            case "maker":
                ArrayList<Food> temp2 = new ArrayList<>();
                System.out.println(temp2);
                for (Food f : foodService.searchAll(new FoodPageBean(sb, st, "1", 1))) {
                    temp2.add(f);
                }
                request.setAttribute("foods", temp2);
                break;
            case "all":
                request.setAttribute("foods", foodService.searchAll(new FoodPageBean()));
                break;
        }
        return new PageInfo(true, "WEB-INF/food/list.jsp");
    }

//    /**
//     * 식품 삭제
//     *
//     * @param request
//     * @param response
//     * @return
//     */
//    public PageInfo delete(HttpServletRequest request, HttpServletResponse response) {
//        String code = request.getParameter("code");
//        bookMgr.delete(isbn);
//        return new PageInfo("main.do?action=foodList");
//    }

}
