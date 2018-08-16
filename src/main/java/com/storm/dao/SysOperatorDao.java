package com.storm.dao;

import org.springframework.stereotype.Repository;

import com.storm.mapper.SysOperatorMapper;
import com.storm.model.SysOperator;
import com.storm.util.LoggingUtil;

@Repository("userDao")
public class SysOperatorDao extends DaoSupport<SysOperatorMapper>{
	/**
	 * 通过id获取操作人员信息
	 * 
	 * @param id
	 * @return
	 * @author 李斯
	 * @date 2018年8月16日 上午11:41:23 
	 * @version V1.0
	 */
    public SysOperator getSysOperatorById(Integer id){
        if(id != null){
            return mapper.selectByPrimaryKey(id);
        }
        return null;
    }

    /**
     * 通过名称获取操作人员信息
     * 
     * @param operatorName
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:41:02 
     * @version V1.0
     */
    public SysOperator getSysOperatorByName(String operatorName) {
        if(operatorName != null){
            return mapper.getSysOperatorByName(operatorName);
        }
        return null;
    }
    
    /**
     * 新增操作人员
     * 
     * @param sysOperator
     * @return
     * @author 李斯
     * @date 2018年8月16日 上午11:40:45 
     * @version V1.0
     */
    public int saveSysOperator(SysOperator sysOperator){
    	return mapper.insert(sysOperator);
    }
}
