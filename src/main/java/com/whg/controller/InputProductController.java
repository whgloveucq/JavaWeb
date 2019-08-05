package com.whg.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult ;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.whg.model.Product2 ;
/**
 * Created by whg at 19-6-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
@Controller
public class InputProductController {
    private static final Log logger=LogFactory.getLog(InputProductController.class);

     @RequestMapping(value="/product_input_upload")
    public String inputProduct(Model model){

         model.addAttribute("product" ,new Product2());

         return "ProductFormUpload" ;
     }
     @RequestMapping(value="/product_save_upload")
     public String saveProduct(HttpServletRequest servletRequest,@ModelAttribute Product2 product,BindingResult bindingResult,Model model) {
         List<MultipartFile> files = product.getImages();
         List<String> fileNames = new ArrayList<String>();
         if (null != files && files.size() > 0) {

             for (MultipartFile multipartFile : files) {
                 String fileName = multipartFile.getOriginalFilename();
                 fileNames.add(fileName);
                 File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                 try {
                     multipartFile.transferTo(imageFile);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }

         }
         //save product here
         model.addAttribute("product" ,product) ;
         return "ProductDetailsUpload" ;
     }

     }




