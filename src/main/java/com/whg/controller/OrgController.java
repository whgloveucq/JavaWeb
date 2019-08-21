package com.whg.controller;
import com.whg.model.Org;
import com.whg.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.ui.Model;
@Controller
@RequestMapping("/OrgManage")
public class OrgController {
    @Autowired
    private OrgService orgService ;

    //insert Org record first

    @RequestMapping("/insertOrg")
    public String AddOrg(Model model){

        model.addAttribute("org",new Org() ) ;
        return "OrgAddForm" ;

    }



    //select Org record second







}
