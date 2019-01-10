package com.whg.model;

/**
 * Created by whg at 19-1-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
//plt_org
public class Org {

    String id ;
    OrgType orgtype;
    String name ;//部门名词
    String pid ;//上级部门
    String state ;//部门状态 0为未启用，1 为 启用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrgType getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(OrgType orgtype) {
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
