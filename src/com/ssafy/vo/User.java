package com.ssafy.vo;

import java.util.List;

public class User {
    private String id;
    private String pw;
    private String name;
    private int age;
    private String gender;
    private List<Food> foodList;

    public User(String id, String pw, String name, int age, String gender, List<Food> foodList) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.foodList = foodList;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
