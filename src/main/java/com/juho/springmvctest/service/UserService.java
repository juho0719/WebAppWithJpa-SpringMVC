package com.juho.springmvctest.service;

import com.juho.springmvctest.model.MyUser;

import java.util.List;

public interface UserService {

    List<MyUser> getAll();
    MyUser findById(int id);
    MyUser findByName(String name);
    void create(String userName);
    void update(String userName);
    void delete(int id);
    boolean exists(MyUser user);
}
