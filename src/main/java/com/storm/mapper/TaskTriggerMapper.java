package com.storm.mapper;

import com.storm.model.TaskTrigger;

public interface TaskTriggerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskTrigger record);

    int insertSelective(TaskTrigger record);

    TaskTrigger selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskTrigger record);

    int updateByPrimaryKey(TaskTrigger record);
}