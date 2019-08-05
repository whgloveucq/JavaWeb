package com.whg.controller;
import com.whg.UtilTools.ProductValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult ;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping ;
import com.whg.model.Product3;

@Controller
public class ProductController {
    private static final Log logger=LogFactory.getLog(ProductController.class);
     @RequestMapping(value = "/product_input")
    public String inputProduct(Model model){

         model.addAttribute("product",new Product3()) ;
         return "ProductForm4" ;
     }
    @RequestMapping(value="/product_save")
    public String saveProduct(@ModelAttribute Product3 product, BindingResult bindingResult,Model model){
        ProductValidator productValidator=new ProductValidator();
        productValidator.validate(product,bindingResult) ;

        if(bindingResult.hasErrors()){
            FieldError fieldError=bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
            model.addAttribute("errors" ,fieldError);
            return "ProductForm4" ;

        }

        //save product here
        model.addAttribute("product" ,product) ;
        return "ProductDetails3" ;

    }



}
