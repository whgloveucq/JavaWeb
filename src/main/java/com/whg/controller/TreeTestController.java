package com.whg.controller;
import com.whg.UtilTools.ZTree;
import com.whg.model.Org;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import com.whg.service.OrgService;
@Controller
@RequestMapping("/Tree")
public class TreeTestController {
    @Autowired
    private OrgService orgService ;
    private static final Log logger= LogFactory.getLog(TreeTestController.class);
    //ZTree 树List集和
    List<ZTree> trees=new ArrayList<ZTree>() ;
    @RequestMapping(value = "/syncZtree")
    public String syncZtree(Model model){
try {
//          String server_id=request.getParameter("server_id");
//          String server_version=request.getParameter("server_version") ;
    List<Org> orgList = new ArrayList<Org>();
    orgList = orgService.selectAllOrgs();// 获取 机构
    List<ZTree> tree = getRecursion(orgList);
    String zTrees = getTree(tree);

    JSONArray json = JSONArray.fromObject(tree);

    JSONObject jb =new JSONObject();

    jb.put("right", json);

    System.out.println("json串="+jb.toString());

//    out.print(jb.toString());
//
//    out.flush();
//
//    out.close();

    //model.addAttribute("Ztrees",zTrees);
    System.out.println("----:" + zTrees);


} catch (Exception e){
    //logger.error(e.getMessage(),e) ;
    System.out.println(e.getMessage());
}
return "ztree_test" ;
    }
    /*
     * 获取zTree数据(机构):将org对象根据ZTree类来组装JSON数据
     * 采用递归算法（我自身的业务需要，数据根据自身需求来组装）
     */
    private List<ZTree> getRecursion(List<Org> treeList){
        for(Org org :treeList){
            ZTree zTree1=new ZTree();
            zTree1.setId(org.getOrgid());
            zTree1.setPid(org.getPid());
            zTree1.setName(org.getName());
            zTree1.setOpen(true);
            zTree1.setParent(true);
            zTree1.setVirtual(false);
            trees.add(zTree1);
            List<Org> list=orgService.selectByWhere(org.getOrgid(),null,null,null,null) ;
            if(list.size() !=0 ){
                for(Org org1:list){
                    ZTree zTree=new ZTree();
                    zTree.setId(org1.getOrgid());
                    zTree.setPid(org1.getPid());
                    zTree.setName(org1.getName());
                    zTree.setOpen(true);
                    zTree.setParent(true);
                    trees.add(zTree);


                }
             //getRecursion(list) ;
            }
        }
        removeDuplicate(trees) ;
        return trees ;
    }
    /**
     *  *  获取设备Tree数据，将Device对象根据ZTree类来组装JSON数据
     *      * @param trees1  机构树
     *      * @param deviceList 设备树
     *      * @return
     *    实际例子没有Device
     */
    public String getTree(List<ZTree> trees1){

        removeDuplicate(trees1) ; //删除重复的list
        StringBuilder str=new StringBuilder() ;
        for(ZTree tree2:trees1){
            str=str.append(tree2.toString()+",") ;
        }
        String s=str.toString().substring(0,str.toString().length()-1) ;
        return "["+s+"]" ;
    }

       //List<ZTree> 重复
    private static void removeDuplicate(List<ZTree> list){
        LinkedHashSet<ZTree> set= new LinkedHashSet<ZTree>(list.size());
        set.addAll(list) ;
        list.clear();
        list.addAll(set);
    }
}
