package com.whg.service;
import org.springframework.stereotype.Service;
import com.whg.mapper.OrgMapper;

import com.whg.model.Org;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrgServiceImpl implements OrgService {
   @Autowired
   private OrgMapper orgMapper ;

    @Override
    public int insert(Org record) {

        if(record.getOrgid() ==null)
        {
            return orgMapper.insert(record) ;
        }
        else
        {
            return orgMapper.updateByPrimaryKeySelective(record) ;
        }

    }

    @Override
    public Org selectByPrimaryKey(String orgid) {
        return orgMapper.selectByPrimaryKey(orgid) ;
    }
}
