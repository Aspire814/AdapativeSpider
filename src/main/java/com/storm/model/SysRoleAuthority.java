package com.storm.model;

import java.util.Date;

public class SysRoleAuthority {
    private Integer id;

    private Integer roleId;

    private Integer authorityId;

    private Date createTime;

    private Date updateTime;

    private Integer updateOpId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateOpId() {
        return updateOpId;
    }

    public void setUpdateOpId(Integer updateOpId) {
        this.updateOpId = updateOpId;
    }
}