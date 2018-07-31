package com.storm.service;

import com.storm.model.SysOperator;;

public interface SysOperatorService {
    public SysOperator selectByPrimarykey(Integer operatorId);
}
