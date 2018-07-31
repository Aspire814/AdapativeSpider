package com.storm.mapper;

import com.storm.model.SysLoginLog;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long loginLogId);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long loginLogId);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKeyWithBLOBs(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}