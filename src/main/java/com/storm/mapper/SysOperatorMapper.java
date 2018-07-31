package com.storm.mapper;

import com.storm.model.SysOperator;

public interface SysOperatorMapper {
    int deleteByPrimaryKey(Integer operatorId);

    int insert(SysOperator record);

    int insertSelective(SysOperator record);

    SysOperator selectByPrimaryKey(Integer operatorId);

    int updateByPrimaryKeySelective(SysOperator record);

    int updateByPrimaryKey(SysOperator record);
    SysOperator getSysOperatorByName(String operatorName);
}