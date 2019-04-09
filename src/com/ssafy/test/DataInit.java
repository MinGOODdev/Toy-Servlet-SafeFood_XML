package com.ssafy.test;

import com.ssafy.service.impl.UserServiceImpl;
import com.ssafy.vo.Food;
import com.ssafy.vo.User;

import java.util.ArrayList;
import java.util.List;

public class DataInit {

    public static void init() {
        List<Food> foodList = new ArrayList<>();
        List<String> allergyList = new ArrayList<>();
        User user = new User("1", "1", "싸피", 28, "남", foodList, allergyList);
        UserServiceImpl.getInstance().add(user);
    }

}
