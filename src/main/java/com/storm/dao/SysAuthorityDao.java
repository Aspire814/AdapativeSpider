package com.storm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.storm.mapper.SysAuthorityMapper;
import com.storm.model.SysAuthority;
import com.storm.util.LoggingUtil;

@Repository("sysAuthorityDao")
public class SysAuthorityDao extends DaoSupport<SysAuthorityMapper> {
    public SysAuthority getAuthorityById(Integer id) {
        if (id != null) {
            return mapper.selectByPrimaryKey(id);
        }
        LoggingUtil.error("SysAuthorityDao", "入参id为null！");
        return new SysAuthority();
    }

    public List<SysAuthority> queryByOperatorId(Integer operatorId) {
        List<SysAuthority> result = new ArrayList<SysAuthority>();
        if (operatorId != null) {
            List<SysAuthority> list = mapper.queryByOperatorId(operatorId);
            if(list != null && list.size() > 0){
                result.addAll(list);
            }
        }
        LoggingUtil.error("SysAuthorityDao", "入参operatorId为null！");
        return result;
    }

    public List<SysAuthority> queryAll() {
        List<SysAuthority> result = new ArrayList<SysAuthority>();
        List<SysAuthority> list = mapper.queryAll();
        if (list != null && list.size() > 0) {
            result.addAll(list);
        }
        return result;
    }
}
