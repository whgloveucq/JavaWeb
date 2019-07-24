package com.whg.service;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import com.whg.model.Org ;
import java.util.ArrayList;
import java.util.List;
public interface OrgService {
    //增加
    //删除
    //修改
    //查询
    Org addOrg(Org org);
    Org deleteOrg(Org org);
    Org updateOrg(Org org) ;
    List<Org> getAllOrg(Org org);
    List<Org> getOrgByWhere() ;//根据条件查询。

}
