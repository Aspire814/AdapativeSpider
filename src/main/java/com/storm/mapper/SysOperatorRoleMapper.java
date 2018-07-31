package com.storm.mapper;

import com.storm.model.SysOperatorRole;

public interface SysOperatorRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperatorRole record);

    int insertSelective(SysOperatorRole record);

    SysOperatorRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperatorRole record);

    int updateByPrimaryKey(SysOperatorRole record);
}