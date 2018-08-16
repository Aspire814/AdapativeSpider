package com.storm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.storm.model.SysOperator;
import com.storm.service.SysOperatorService;

@Controller
public class SysOperatorController {
    @Autowired
    private SysOperatorService sysOperatorService;

    /**
     * 返回后台首页
     * 
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:50:36 
     * @version V1.0
     */
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    /**
     * 登录页
     * 
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:50:55 
     * @version V1.0
     */
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
    
    /**
     * 首页
     * 
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:51:05 
     * @version V1.0
     */
    @RequestMapping(value={"/index","/"})
    public String index(){
        return "index";
    }
    
    /**
     * 用户注册页面
     * 
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:36:18 
     * @version V1.0
     */
    @RequestMapping("/register")
    public String register(SysOperator user){
        return "register";
    }
    
    /**
     * 用户注册行为
     * 
     * @param user
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:44:35 
     * @version V1.0
     */
    @RequestMapping("/doregister")
    @ResponseBody
    public String doregister(SysOperator user){
    	//用户名时候存在校验
    	boolean exists = sysOperatorService.isExits(user.getOperatorName());
    	if(!exists){
    		boolean flag = sysOperatorService.register(user);
        	if(flag){
        		return "true";
        	}
        	return "false";
    	}else{
    		return "exists";
    	}
    }
    
}
