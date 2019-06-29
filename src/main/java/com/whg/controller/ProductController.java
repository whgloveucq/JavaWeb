package com.whg.controller;

/**
 * Created by whg at 19-6-24
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whg.model.Product1;
import com.whg.form.ProductForm;
//import org.springframework.web.servlet.DispatcherServlet;
@Controller
@RequestMapping(value="/springweb")
public class ProductController {
    private static final Log logger=LogFactory.getLog(ProductController.class);
    @RequestMapping(value="/product_input")
    public String inputProduct(){
        logger.info("inputProduct called") ;
        return "ProductForm" ;

    }
    @RequestMapping(value="/product_save")
    public String saveProduct(ProductForm productForm , Model model){
        logger.info("saveProduct called") ;
         //no need to create and instantiate a ProductForm
        //create Product
        Product1 product=new Product1();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Float.parseFloat(
                    productForm.getPrice()
            ));
        } catch (NumberFormatException e){}
        // add product
        model.addAttribute("product",product);
        return "ProductDetails" ;
    }


}
