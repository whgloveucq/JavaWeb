package com.whg.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.whg.model.Org;
import com.whg.service.OrgService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import  org.springframework.ui.Model;

import java.util.*;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.validation.Valid;
import org.hibernate.validator.constraints.*;


@Controller
@RequestMapping("/OrgManage")
public class OrgController {
    @Autowired
    private OrgService orgService ;
    private static final Log logger=LogFactory.getLog(OrgController.class);
    private  HttpSession session=new HttpSession() {
        @Override
        public long getCreationTime() {
            return 0;
        }

        @Override
        public String getId() {
            return null;
        }

        @Override
        public long getLastAccessedTime() {
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public void setMaxInactiveInterval(int i) {

        }

        @Override
        public int getMaxInactiveInterval() {
            return 0;
        }

        @Override
        public HttpSessionContext getSessionContext() {
            return null;
        }

        @Override
        public Object getAttribute(String s) {
            return null;
        }

        @Override
        public Object getValue(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String[] getValueNames() {
            return new String[0];
        }

        @Override
        public void setAttribute(String s, Object o) {

        }

        @Override
        public void putValue(String s, Object o) {

        }

        @Override
        public void removeAttribute(String s) {

        }

        @Override
        public void removeValue(String s) {

        }

        @Override
        public void invalidate() {

        }

        @Override
        public boolean isNew() {
            return false;
        }
    };


    //see what has been there in the table of database
   @RequestMapping("/orglist")
    public String Org(@RequestParam(value = "currentPage",defaultValue = "1")String currentPage, Model model ){

        if(Integer.parseInt(currentPage)==1){
            PageHelper.startPage(1,7);

        }

       PageHelper.startPage(Integer.parseInt(currentPage),7);


            List<Org> org=orgService.selectAllOrgs();




       PageInfo<Org> info=new PageInfo<Org>(org);
       model.addAttribute("page",info);
        model.addAttribute("org",org ) ;
        return "OrgAddForm" ;

    }
@RequestMapping("/orgListSelective")
public  String Org(@RequestParam(value = "currentPage",defaultValue = "1")String currentPage, Model model,@RequestParam(value = "orgid" )String orgid,@RequestParam(value = "orgtype")String orgtype,
                   @RequestParam(value = "name")String name, @RequestParam(value = "pid")String pid  , @RequestParam(value = "state")String state )
    {


        if(Integer.parseInt(currentPage)==1){
            PageHelper.startPage(1,7);

        }

        List<Org> org;

        PageHelper.startPage(Integer.parseInt(currentPage),7);
        if( orgid =="" && orgtype =="" && name == "" && pid == "" && state==""){

         org=orgService.selectAllOrgs();

        }

        else {
        org = orgService.selectByWhere(orgid, orgtype, name, pid, state);

        }

        PageInfo<Org> info=new PageInfo<Org>(org);
        model.addAttribute("page",info);
        model.addAttribute("org",org ) ;
        return "OrgAddForm" ;

}

    //



//    新增或修改机构信息页面，使用get跳转到页面
    @RequestMapping(value = "/insertOrg" ,method = RequestMethod.GET)
    public String AddOrg( Model model,String id){
       Org org;

       if(id == null) {
           //如果id不存在，就是新增数据，创建一个空对象即可
           org = new Org();

           if(session.getAttribute("SessionErrors")!=null)
           {
              model.addAttribute("errors",session.getAttribute("SessionErrors"));
               model.addAttribute("msg", "ok"+session.getAttribute("SessionErrors"));

           }
           model.addAttribute("msg", "ok");

       }
       else{
           //如果id存在，就是修改数据，把原有的数据查询出来。
           org= orgService.selectByPrimaryKey(id);
           model.addAttribute("msg","ok");
       }
      model.addAttribute("org",org) ;
       return "Org_AddForm" ;

    }
    //    新增或修改机构信息页面，使用post跳转到页面

    @RequestMapping(value = "/insertOrg" ,method = RequestMethod.POST)
//   @ResponseBody
    public String AddOrg(@Valid @ModelAttribute("org")  Org org, BindingResult bindingResult, Model model){
        try{
//            ArrayList<String> errorList= new ArrayList<String>();
         if(bindingResult.hasErrors()){
//
//               for(int i=0 ;i < bindingResult.getErrorCount();i++ ){
//                   errorList.add(bindingResult.getFieldError().getRejectedValue().toString()) ;
//
//                  session.setAttribute("errors",errorList);
//               }

            //  model.addAttribute("errors",errorList);
            //   return   "redirect:/OrgManage/Org_AddForm" ;
             Map<String,Object> map=new HashMap<String,Object>();
             for (FieldError fieldError : bindingResult.getFieldErrors()){
                 System.out.println(fieldError.getField()+ " : " + fieldError.getDefaultMessage()+":"+fieldError.getRejectedValue());
               //  errors.add(fieldError);
                 map.put(fieldError.getField(),fieldError.getDefaultMessage());

             }
             //System.out.println(errors);
             List<FieldError> errorFields= bindingResult.getFieldErrors();

               model.addAttribute("errors",errorFields);

             session.setAttribute("SessionErrors",errorFields);
              System.out.println(errorFields);
             return "redirect:/OrgManage/insertOrg" ;


           }
           else{
            orgService.insert(org) ;
            List<Org> org1=orgService.selectAllOrgs();
            model.addAttribute("org",org1);
          //  return "redirect:/OrgAddForm" ;
           //return "OrgAddForm" ;
            return "redirect:/OrgManage/orglist" ;
        }
      }
        catch (Exception e){
        model.addAttribute("msg",e.getMessage());
        //model.addAttribute("org",org1);
            return "Org_AddForm" ;


        }


    }


//通过id删除字典信息

    @RequestMapping(value="/deleteOrg" ,method=RequestMethod.POST )
    @ResponseBody
    public void delete(Model model ,@RequestParam(value = "id")  String id){
       try{



           int success=orgService.deleteByPrimaryKey(id);
           if(success != 0 ){
               model.addAttribute("success",success);
           }

       }catch (Exception e){
           model.addAttribute("success",0);
           model.addAttribute("msg",e.getMessage());
       }
    }

   //更新机构信息
    @RequestMapping(value="/updateOrg" ,method = RequestMethod.GET)
    public String toUpdateOrg(Model model,@RequestParam(value = "orgid") String orgid)
    {



        try {
//           Org record = new Org();

//           record.setOrgid(orgid);
           Org record= orgService.selectByPrimaryKey(orgid);
           model.addAttribute("org",record) ;
           return "Org_EditForm";

          // int success = orgService.updateByPrimaryKeySelective(record);
       }
       catch (Exception e)
       {
//           model.addAttribute("success",0);
           model.addAttribute("msg",e.getMessage());
           return  null;

       }

    }

    @RequestMapping(value="/updateOrgF" ,method = RequestMethod.POST)

    public String toUpdateOrg(Model model,Org org)
    {

        try {
            session.setAttribute("org",org);

            int success = orgService.updateByPrimaryKeySelective(org);


            if (success != 0) {
                model.addAttribute("success", success);
//                return "OrgAddForm";
              //  return  success;
                return "redirect:/OrgManage/orglist" ;
                //再丰富交互体验
            }

        } catch (Exception e) {
            model.addAttribute("success", 0);
            model.addAttribute("msg", e.getMessage());
           return null;
        }
        return null;
    }








}
