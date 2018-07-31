package com.storm.model;

import java.util.Date;

public class SysAuthority {
    private Integer authorityId;

    private String authorityCode;

    private String authorityName;

    private String authorityDesc;

    private Integer authorityType;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer updateOpId;
    
    private String authorityUrl;

    private String authorityMethod;
    
    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode == null ? null : authorityCode.trim();
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc == null ? null : authorityDesc.trim();
    }

    public Integer getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(Integer authorityType) {
        this.authorityType = authorityType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getAuthorityUrl() {
        return authorityUrl;
    }

    public void setAuthorityUrl(String authorityUrl) {
        this.authorityUrl = authorityUrl;
    }

    public String getAuthorityMethod() {
        return authorityMethod;
    }

    public void setAuthorityMethod(String authorityMethod) {
        this.authorityMethod = authorityMethod;
    }
    
}