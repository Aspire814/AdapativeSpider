package com.storm.mapper;

import java.util.List;

import com.storm.model.SysAuthority;

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
    
    List<SysAuthority> queryAll();
    
    List<SysAuthority> queryByOperatorId(Integer operatorId);
}