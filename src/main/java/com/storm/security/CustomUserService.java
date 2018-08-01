package com.storm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.storm.dao.SysAuthorityDao;
import com.storm.dao.SysOperatorDao;
import com.storm.model.SysAuthority;
import com.storm.model.SysOperator;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private SysAuthorityDao sysAuthorityDao;
    @Autowired
    private SysOperatorDao sysOperatorDao;
    @Override
    public UserDetails loadUserByUsername(String userName) { //重写loadUserByUsername 方法获得 userdetails 类型用户
        SysOperator sysOperator = sysOperatorDao.getSysOperatorByName(userName);
        if (sysOperator != null) {
            List<SysAuthority> authorities = sysAuthorityDao.queryByOperatorId(sysOperator.getOperatorId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (SysAuthority authority : authorities) {
                if (authority != null && authority.getAuthorityUrl() != null && authority.getAuthorityMethod() != null) {
                    GrantedAuthority grantedAuthority = new CustomGrantedAuthority(authority.getAuthorityUrl(),authority.getAuthorityMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            sysOperator.setAuthorities(grantedAuthorities);
            return sysOperator;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}