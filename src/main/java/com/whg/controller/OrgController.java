package com.whg.controller;
import com.whg.model.Org;
import com.whg.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Controller
@RequestMapping("/OrgManage")
public class OrgController {
    @Autowired
    private OrgService orgService ;
    private static final Log logger=LogFactory.getLog(OrgController.class);


    //see what has been there in the table of database
   @RequestMapping("/orglist")
    public String Org(Model model ){

        List<Org> org=orgService.selectAllOrgs();
        model.addAttribute("org",org ) ;
        return "OrgAddForm" ;

    }
    @RequestMapping(value = "/insertOrg" ,method = RequestMethod.POST)
    public String AddOrg(Org org){
        try{
            orgService.insert(org) ;
        }
        catch (Exception e){

        }
        return "OrgAddForm" ;
    }


    //select Org record second







}
