package com.storm.model;

import java.util.Date;

public class TaskInfo {
    private Long id;

    private String beanclass;

    private String methodname;

    private String isconcurrent;

    private String description;

    private String updateby;

    private Date createdate;

    private String jobstatus;

    private String jobgroup;

    private Date updatedate;

    private String createby;

    private String jobname;

    private String params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeanclass() {
        return beanclass;
    }

    public void setBeanclass(String beanclass) {
        this.beanclass = beanclass == null ? null : beanclass.trim();
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname == null ? null : methodname.trim();
    }

    public String getIsconcurrent() {
        return isconcurrent;
    }

    public void setIsconcurrent(String isconcurrent) {
        this.isconcurrent = isconcurrent == null ? null : isconcurrent.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getJobstatus() {
        return jobstatus;
    }

    public void setJobstatus(String jobstatus) {
        this.jobstatus = jobstatus == null ? null : jobstatus.trim();
    }

    public String getJobgroup() {
        return jobgroup;
    }

    public void setJobgroup(String jobgroup) {
        this.jobgroup = jobgroup == null ? null : jobgroup.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}