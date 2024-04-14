package com.leesee.userservice.controller;

import com.leesee.entity.User;
import com.leesee.userservice.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
public class UserController {

    @Autowired
    private  UserMapper userMapper;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id){
        User user=userMapper.findById(id);
        log.info("-------------OK /findById/{id}--------------------");
        return user;
    }


    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username){
        User user=userMapper.findByUsername(username);
        log.info("-------------OK /findByUsername/{username}--------------------");
        log.info("{}",user);
        return user;
    }

    @PostMapping("/createUser")
    public boolean createUser(@RequestBody User user){
        if(userMapper.findByUsername(user.getUsername())!=null){
            return false;
        }
        userMapper.insert(user);
        return true;
    }

}
