package com.storm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.storm.dao.UserDao;
import com.storm.model.User;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User selectByPrimarykey(Integer userCode) {
        User user = null;
        if(userDao != null){
            user = userDao.getUserById(userCode);
        }else{
            System.out.println("UserMapper is null");
        }
        return user;
    }
}