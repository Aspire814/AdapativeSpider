package com.storm.service;

import com.storm.model.SysOperator;;

public interface SysOperatorService {
    public SysOperator selectByPrimarykey(Integer operatorId);
    
    /**
     * 用户注册
     * 
     * @param user
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:37:48 
     * @version V1.0
     */
    public boolean register(SysOperator user);
    
    /**
     * 检查此账户是否存在
     * 
     * @param name
     * @return
     * @author 李斯
     * @date 2018年8月16日 下午2:05:51 
     * @version V1.0
     */
    public boolean isExits(String name);
}
