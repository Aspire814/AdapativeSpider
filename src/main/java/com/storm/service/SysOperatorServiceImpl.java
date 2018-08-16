package com.storm.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.storm.dao.SysOperatorDao;
import com.storm.model.SysOperator;

@Service("userService")
public class SysOperatorServiceImpl implements SysOperatorService {
    @Resource
    private SysOperatorDao sysOperatorDao;
    @Override
    public SysOperator selectByPrimarykey(Integer operatorId) {
        SysOperator user = null;
        if(sysOperatorDao != null){
            user = sysOperatorDao.getSysOperatorById(operatorId);
        }else{
            System.out.println("SysOperator is null");
        }
        return user;
    }
	/**
	 * 
	 * @param user
	 * @return
	 * @author 李斯
	 * @date 2018年8月16日 上午11:37:59 
	 * @version V1.0
	 * @see com.storm.service.SysOperatorService#register(com.storm.model.SysOperator)
	 */
	@Override
	public boolean register(SysOperator user) {
		return (sysOperatorDao.saveSysOperator(user)) > 0 ? true : false;
	}
	
	/**
	 * 判断用户是否已经存在
	 * 
	 * @return
	 * @author 李斯
	 * @date 2018年8月16日 下午1:53:52 
	 * @version V1.0
	 */
	@Override
	public boolean isExits(String name){
		if(StringUtils.isNotBlank(name)){
			SysOperator operator = sysOperatorDao.getSysOperatorByName(name);
			return (operator != null) ? true : false;
		}
		return false;
	}
}