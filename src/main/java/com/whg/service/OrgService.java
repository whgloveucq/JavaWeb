package com.whg.service;
import com.whg.model.Org ;

public interface OrgService {

    int insert(Org record);

    Org selectByPrimaryKey(String orgid);

}
