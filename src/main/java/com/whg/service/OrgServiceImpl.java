package com.whg.service;
import com.whg.model.Org;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

      private List<Org> orgs;
      public OrgServiceImpl(){
          orgs= new ArrayList<Org>() ;
          Org org1= new Org("660000006","01","科技与产品管理部","000000000", "0","test");
          Org org2= new Org("660001964","01","安全设备部","660000006", "1","test");
          Org org3 = new Org("660001963","01","系统管理部","660000006", "1","test");
          Org org4 = new Org("660001962","01","网络管理部","660000006", "1","test");
          Org org5 = new Org("660001960","01","软件开放一部","660000006", "0","test");
          Org org6 = new Org("660002021","01","软件开放二部","660000006", "0","test");
          Org org7 = new Org("660002027","01","产品研发部","660000006", "0","test");
          Org org8 = new Org("660001961","01","数据运行部","660000006", "0","test");
          orgs.add(org1);
          orgs.add(org2);
          orgs.add(org3);
          orgs.add(org4);
          orgs.add(org5);
          orgs.add(org6);
          orgs.add(org7);

      }

    @Override
    public Org addOrg(Org org) {
        return null;
    }

    @Override
    public Org deleteOrg(Org org) {
        return null;
    }

    @Override
    public Org updateOrg(Org org) {
        return null;
    }

    @Override
    public List<Org> getAllOrg(Org org) {
        return orgs;
    }

    @Override
    public List<Org> getOrgByWhere() {
        return null;
    }
}
