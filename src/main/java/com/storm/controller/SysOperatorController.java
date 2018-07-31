package com.storm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.storm.model.SysOperator;
import com.storm.service.SysOperatorService;

@Controller
public class SysOperatorController {
    @Autowired
    private SysOperatorService sysOperatorService;
    private final static Logger logger = LoggerFactory.getLogger(SysOperatorController.class);

    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "admin";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        return "login success";
    }
    @RequestMapping("/")
    @ResponseBody
    public String root(){
        return "root";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        return "home";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
