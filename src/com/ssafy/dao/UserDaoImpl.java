package com.ssafy.dao;

import com.ssafy.vo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    private List<User> users;

    /**
     * 싱글톤
     */
    private static UserDaoImpl userDao;
    public static UserDaoImpl getInstance() {
        if (userDao == null) userDao = new UserDaoImpl();
        return userDao;
    }

    private UserDaoImpl() {
        users = new ArrayList<>();
    }

    /**
     * 회원 전체 조회
     *
     * @return
     */
    public List<User> findAll() {
        return users;
    }

    /**
     * 회원 등록
     *
     * @param user
     */
    public void add(User user) {
        users.add(user);
    }

    /**
     * 회원 삭제
     *
     * @param id
     */
    public void delete(String id) {
        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i).getId().equalsIgnoreCase(id)) users.remove(i);
        }
    }

    /**
     * 회원 검색 (이름)
     *
     * @param name
     * @return
     */
    public User[] searchByName(String name) {
        int count = 0;
        for (User u : users) {
            if (u.getName().equals(name)) ++count;
        }

        User[] temp = new User[count];
        int idx = 0;
        for (User u : users) {
            if (u.getName().equals(name)) temp[idx++] = u;
        }
        return temp;
    }
}
