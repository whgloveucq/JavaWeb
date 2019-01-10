package com.whg.model;

/**
 * Created by whg at 19-1-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class Document {
    String id;
    docsyskind syskind; //工作大类
    docsysname sysname;
    workchannel channel;
    dockind     kind; //文档类型
    Staff staff;
    String recordate ; //记录日期
    String dis_date;  //显示日期，勇于任务预期安排
    String content; //内容
    String title  ;//标题

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public docsyskind getSyskind() {
        return syskind;
    }

    public void setSyskind(docsyskind syskind) {
        this.syskind = syskind;
    }

    public docsysname getSysname() {
        return sysname;
    }

    public void setSysname(docsysname sysname) {
        this.sysname = sysname;
    }

    public workchannel getChannel() {
        return channel;
    }

    public void setChannel(workchannel channel) {
        this.channel = channel;
    }

    public dockind getKind() {
        return kind;
    }

    public void setKind(dockind kind) {
        this.kind = kind;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getRecordate() {
        return recordate;
    }

    public void setRecordate(String recordate) {
        this.recordate = recordate;
    }

    public String getDis_date() {
        return dis_date;
    }

    public void setDis_date(String dis_date) {
        this.dis_date = dis_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
