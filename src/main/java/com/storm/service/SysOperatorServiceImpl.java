package com.storm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.storm.dao.SysOperatorDao;
import com.storm.model.SysOperator;

@Service("userService")
public class SysOperatorServiceImpl implements SysOperatorService {
    @Resource
    private SysOperatorDao sysOperatorDao;

    public SysOperator selectByPrimarykey(Integer operatorId) {
        SysOperator user = null;
        if(sysOperatorDao != null){
            user = sysOperatorDao.getSysOperatorById(operatorId);
        }else{
            System.out.println("SysOperator is null");
        }
        return user;
    }
}