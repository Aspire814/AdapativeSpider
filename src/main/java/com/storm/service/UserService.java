package com.storm.service;

import com.storm.model.User;

public interface UserService {
    public User selectByPrimarykey(Integer userCode);
}
