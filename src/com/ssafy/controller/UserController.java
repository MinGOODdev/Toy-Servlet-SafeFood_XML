package com.ssafy.controller;

import com.ssafy.dao.FoodDaoImpl;
import com.ssafy.dao.UserDaoImpl;
import com.ssafy.service.CheckService;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.PageInfo;
import com.ssafy.vo.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserController {
    private CheckService checkService = CheckService.getInstance();
    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private FoodDaoImpl foodDao = FoodDaoImpl.getInstance();

    /**
     * 싱글톤
     */
    private static UserController userController;
    public static UserController getInstance() {
        if (userController == null) userController = new UserController();
        return userController;
    }

    /**
     * 로그인
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo login(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        String pw = request.getParameter("pw");
//        String check = request.getParameter("idSave");
//
//        HashMap<String, String> errorMessages = checkService.checkNullForLogin(id, pw);
//        if (errorMessages.size() > 0) {
//            request.setAttribute("errorMessages", errorMessages);
//            return new PageInfo(true, "login.jsp");
//        }

        return new PageInfo("main.do?action=foodList");

//        boolean flag = checkService.checkAccount(id, pw);
//        if (flag) {
//            HttpSession session = request.getSession();
//            session.setAttribute("userId", id);
//
//            if (check != null && check.equals("on")) {
//                Cookie c = new Cookie("userId", id);
//                response.addCookie(c);
//            }
//            return new PageInfo("main.do?action=foodList");
//        } else return new PageInfo(true, "login.jsp");
    }

    /**
     * 로그아웃
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return new PageInfo("login.jsp");
    }

    /**
     * 회원가입
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo signUp(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");

        HashMap<String, String> errorMessages = checkService.checkForSignUp(id, pw, name, age, gender);
        if (errorMessages.size() > 0) {
            request.setAttribute("errorMessages", errorMessages);
            return new PageInfo(true, "signUp.jsp");
        }

        User user = new User(id, pw, name, age, gender, new ArrayList<Food>());
        userDao.add(user);
        return new PageInfo("login.jsp");
    }

    /**
     * 회원 전체 목록 조회
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo getUserList(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userDao.findAll();
        request.setAttribute("users", users);
        return new PageInfo(true, "WEB-INF/user/list.jsp");
    }

    /**
     * 회원 삭제
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        userDao.delete(id);
        return new PageInfo("main.do?action=userList");
    }

    /**
     * 해당 회원의 구매(섭취) 내역 조회
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo getPurchaseListByUser(HttpServletRequest request, HttpServletResponse response) {
        String id = (String) request.getSession().getAttribute("userId");
        for (User u : userDao.findAll()) {
            if (u.getId().equalsIgnoreCase(id)) request.setAttribute("purchaseList", u.getFoodList());
        }
        return new PageInfo(true, "WEB-INF/user/orderList.jsp");
    }

    /**
     * 식품 구매(섭취)
     *
     * @param request
     * @param response
     * @return
     */
    public PageInfo doPurchase(HttpServletRequest request, HttpServletResponse response) {
        String id = (String) request.getSession().getAttribute("userId");
        String code = request.getParameter("code");

        Food temp = null;
        for (Food b : foodDao.searchAll(new FoodPageBean())) {
            if (b.getName().equals(code)) temp = b;
        }

        for (User u : userDao.findAll()) {
            if (u.getId().equalsIgnoreCase(id)) u.getFoodList().add(temp);
        }
        return new PageInfo("main.do?action=foodList");
    }

}
