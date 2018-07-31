package com.storm.dao;

import org.springframework.stereotype.Repository;

import com.storm.mapper.SysOperatorMapper;
import com.storm.model.SysOperator;
import com.storm.util.LoggingUtil;

@Repository("userDao")
public class SysOperatorDao extends DaoSupport<SysOperatorMapper>{
    public SysOperator getSysOperatorById(Integer id){
        if(id != null){
            return mapper.selectByPrimaryKey(id);
        }
        LoggingUtil.error("SysOperatorDao", "入参id为null！");
        return new SysOperator();
    }

    public SysOperator getSysOperatorByName(String operatorName) {
        if(operatorName != null){
            return mapper.getSysOperatorByName(operatorName);
        }
        LoggingUtil.error("SysOperatorDao", "入参operatorName为null！");
        return new SysOperator();
    }
}
