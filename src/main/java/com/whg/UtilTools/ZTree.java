package com.whg.UtilTools;

//zTree 树
//id（节点id）,pid(父节点),name 必须要有
//其他属性可以根据需求自行添加
//@createtime 20191014


public class ZTree {

    private String id; //节点id
    private String pid; //父节点id
    private String name ; //节点 name
    private boolean open ;// 节点打开，关闭false 默认为false
    private boolean isParent ; //是否为父节点,
    private boolean isVirtual ;// 是否为虚拟 机构

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public void setVirtual(boolean virtual) {
        isVirtual = virtual;
    }

//    重写toString(),生成前台需要的JSON数据
    @Override
    public String toString() {
StringBuilder sb= new StringBuilder();

        sb.append("{id:\"");
        sb.append(id);
        sb.append("{id:\"");
        sb.append(id);
        sb.append("{pid:\"");
        sb.append(pid);
        sb.append("{name:\"");
        sb.append(name);
        sb.append("{open:\"");
        sb.append(open);
        sb.append("{isParent:\"");
        sb.append(isParent);
        sb.append("{isVirtual:\"");
        sb.append(isVirtual);
        sb.append("\"}");
        return sb.toString();
    }
    /*
   重写equals()和hashCode()，用于List<Ztree>的去重复对象:
   根据id,pid,name,三者属性去重复
   */ @Override public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZTree zTree = (ZTree) o; if (!id.equals(zTree.id)) return false;
        if (!pid.equals(zTree.pid)) return false;
        return name.equals(zTree.name) && id.equals(zTree.id) && pid.equals(zTree.pid) ;
    }
    @Override public int hashCode()
    {
        int result = id.hashCode();
        result = 31 * result + pid.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }









}
