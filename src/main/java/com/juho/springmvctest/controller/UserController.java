package com.juho.springmvctest.controller;

import com.juho.springmvctest.model.MyUser;
import com.juho.springmvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/get/no/{userNo}", method = RequestMethod.GET)
    public MyUser getUserForNo(@PathVariable Integer userNo) {
        return userService.findById(userNo);
    }

    @RequestMapping(value = "/get/name/{userName}", method = RequestMethod.GET)
    public MyUser getUserForName(@PathVariable String userName) {
        return userService.findByName(userName);
    }

    @RequestMapping(value = "/save/{userName}", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@PathVariable String userName) {
        userService.create(userName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{userNo}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Integer userNo) {
        if(userService.findById(userNo) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(userNo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
