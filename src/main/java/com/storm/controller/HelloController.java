package com.storm.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.storm.model.User;
import com.storm.service.UserService;
import com.storm.util.LoggingUtil;

@RestController
@RequestMapping("/demo")
public class HelloController {
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @Resource
    private UserService userService;
    
    @RequestMapping("/hello")
    @ResponseBody
    public User getUser(){
        LoggingUtil.info("hello testing", "获取用户信息！");;
        User user = userService.selectByPrimarykey(1);
        return user;
    }
}
