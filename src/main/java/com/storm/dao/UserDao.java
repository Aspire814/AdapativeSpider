package com.storm.dao;

import org.springframework.stereotype.Repository;

import com.storm.mapper.UserMapper;
import com.storm.model.User;

@Repository("userDao")
public class UserDao extends DaoSupport<UserMapper>{
    public User getUserById(Integer id){
        return mapper.selectByPrimaryKey(id);
    }
}
