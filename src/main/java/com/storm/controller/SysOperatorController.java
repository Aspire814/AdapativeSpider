package com.storm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.storm.service.SysOperatorService;

@Controller
public class SysOperatorController {
    @Autowired
    private SysOperatorService sysOperatorService;
    private final static Logger logger = LoggerFactory.getLogger(SysOperatorController.class);

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "test");
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        mv.addObject("numbers", numbers);
        mv.setViewName("test");
        return mv;
    }
    
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    
    @RequestMapping(value={"/index","/"})
    public String index(){
        return "index";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
