package com.whg.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.whg.model.Product2;


@Controller
public class Product2Controller {

    private static final Log logger=LogFactory.getLog(Product2Controller.class) ;

    @RequestMapping(value="/product_input2")
    public String inputProduct(Model model){
        model.addAttribute("product" , new Product2());
        return "ProductForm5" ;
    }

    @RequestMapping(value="/product_save2")
    public String saveProduct(HttpServletRequest servletRequest, @ModelAttribute Product2 product ,BindingResult bindingResult,Model model){

        List<MultipartFile> files=product.getImages() ;
        List<String> fileNames=new ArrayList<String>();
        if(null != files && files.size()>0){
            for(MultipartFile multipartFile:files){
                String fileName=multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                System.out.println(servletRequest.getContextPath().toString());

                System.out.println(servletRequest.getServletContext().getRealPath("/images"));
                File imageFile=new File(servletRequest.getServletContext().getRealPath("/images"),fileName) ;
                try{
                    multipartFile.transferTo(imageFile);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        //save product here
        String serverPath= servletRequest.getContextPath().toString();
        model.addAttribute("product",product) ;
        model.addAttribute("serverpath",serverPath);
        return "ProductDetails5" ;

    }


}
