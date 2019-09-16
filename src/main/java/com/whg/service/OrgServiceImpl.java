package com.whg.service;
import org.springframework.stereotype.Service;
import com.whg.mapper.OrgMapper;

import com.whg.model.Org;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {
   @Autowired
   private OrgMapper orgMapper ;

    @Override
    public int insert(Org record) {
        return orgMapper.insert(record) ;

//        if(record.getOrgid() ==null)
//        {
//            return orgMapper.insert(record) ;
//        }
//        else
//        {
//            return orgMapper.updateByPrimaryKeySelective(record) ;
//        }

    }

    @Override
    public Org selectByPrimaryKey(String orgid) {
        return orgMapper.selectByPrimaryKey(orgid) ;
    }

    @Override
    public List<Org> selectAllOrgs() {
        return orgMapper.selectAllOrgs();
    }

    @Override
    public List<Org> selectByWhere(String orgid, String orgtype, String name, String pid, String state) {
        return orgMapper.selectByWhere(orgid,orgtype,name,pid,state);
    }

    @Override
    public int deleteByPrimaryKey(String orgid) {

        return orgMapper.deleteByPrimaryKey(orgid);

    }

    @Override
    public int updateByPrimaryKeySelective(Org record) {

        return orgMapper.updateByPrimaryKeySelective(record);

    }
}
