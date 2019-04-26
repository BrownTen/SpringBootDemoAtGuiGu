package com.wyt.springboot.controller;

import com.wyt.springboot.entity.User;
import com.wyt.springboot.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRespository userRespository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = userRespository.getOne(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRespository.save(user);
        return save;
    }
}
