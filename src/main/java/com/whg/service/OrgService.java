package com.whg.service;
import com.whg.model.Org ;
import java.util.List;

public interface OrgService {

    int insert(Org record);
    List<Org> selectAllOrgs() ;
    List<Org> selectByWhere(String orgid,String  orgtype, String name,String pid,String state);

    Org selectByPrimaryKey(String orgid);

    int deleteByPrimaryKey(String orgid);

    int updateByPrimaryKeySelective(Org record);
}
