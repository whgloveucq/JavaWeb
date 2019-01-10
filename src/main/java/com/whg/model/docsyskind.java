package com.whg.model;

/**
 * Created by whg at 19-1-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
/*文档系统类型---工作大类*/
public class docsyskind {
    String id;
    String name;
    String comment ;/*备注*/

    public docsyskind(String id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
