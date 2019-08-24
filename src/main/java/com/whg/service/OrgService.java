package com.whg.service;
import com.whg.model.Org ;
import java.util.List;

public interface OrgService {

    int insert(Org record);
    List<Org> selectAllOrgs() ;
    Org selectByPrimaryKey(String orgid);

}
