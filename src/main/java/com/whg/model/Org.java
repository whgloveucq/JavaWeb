package com.whg.model;

/**
 * Created by whg at 19-1-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
//plt_org
public class Org {

    String id ; //部门号码，外部单位为 统一信用正号码或组织机构代码
    //OrgType orgtype; //内部单位01，外部单位 02（系统内，系统外）
    String orgtype ;
    String name ;//部门名词
    String pid ;//上级部门
    String state ;//部门状态 0为未启用，1 为 启用
    String description ; //部门情况描述

    public Org(String id, String orgtype, String name, String pid, String state, String description) {
        this.id = id;
        this.orgtype = orgtype;
        this.name = name;
        this.pid = pid;
        this.state = state;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
