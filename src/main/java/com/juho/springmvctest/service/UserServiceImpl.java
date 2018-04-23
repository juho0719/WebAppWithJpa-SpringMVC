package com.juho.springmvctest.service;

import com.juho.springmvctest.model.MyUser;
import com.juho.springmvctest.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private AtomicInteger curSeq = new AtomicInteger(0);

    @Override
    public List<MyUser> getAll() {
        List<MyUser> userList = new ArrayList<MyUser>();

        for (MyUser user : userRepository.findAll()) {
            userList.add(user);
        }
        return userList;
    }

    @Override
    public MyUser findById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public MyUser findByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    @Transactional
    public void create(String userName) {
        MyUser user = new MyUser();
        user.setId(curSeq.incrementAndGet());
        user.setUsername(userName);
        userRepository.save(user);
    }

    @Override
    public void update(String userName) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean exists(MyUser user) {
        return false;
    }
}
