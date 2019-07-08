package com.whg.controller;

/**
 * Created by whg at 19-6-24
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import com.whg.service.ProductService;
import com.whg.service.ProductServiceImpl;
import com.whg.validator.ProductValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whg.model.Product;
import com.whg.model.Product1;
import com.whg.form.ProductForm;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.whg.service.ProductService;


import java.util.List;

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
        ProductValidator productValidator=new ProductValidator();
        List<String> errors=productValidator.validate(productForm);
        if(errors.isEmpty()) {

            //create model
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {

            }
            model.addAttribute("product",product);
            return "ProductDetails" ;

        }
        else{
            //store errors and form in a scope variable for the view
            model.addAttribute("errors",errors);
            model.addAttribute("form",productForm);
//            return "/WEB-INF/jsp/ProductForm.jsp" ;
            return "ProductForm" ;
        }

    }
    @RequestMapping(value = "/product_savee" ,method= RequestMethod.POST)
    public String save2Product(ProductForm productForm, RedirectAttributes redirectAttributes){
logger.info("save Product called") ;
//no need to create and instantiate a ProductForm
        //create Product
        Product product=new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Double.parseDouble(productForm.getPrice());

        }catch (NumberFormatException e){}
        ProductService productService =new ProductServiceImpl();
        Product saveProduct=productService.add(product);
        redirectAttributes.addFlashAttribute("message" ,"The product was successfully added") ;
        return "redirect:/product_view/" + saveProduct.getId();
    }

}
