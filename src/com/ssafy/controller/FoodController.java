package com.ssafy.controller;

import com.ssafy.service.FoodServiceImpl;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodController {
    private FoodServiceImpl foodService = FoodServiceImpl.getInstance();

    private static FoodController foodController;
    public static FoodController getInstance() {
        if (foodController == null) foodController = new FoodController();
        return foodController;
    }

    /**
     * 모든 음식 조회
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo getBookList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("foods", foodService.searchAll(new FoodPageBean()));
        System.out.println(foodService.searchAll(new FoodPageBean()));
        return new PageInfo(true, "WEB-INF/book/list.jsp");
    }
}
