package com.whg.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whg.model.Product;
import com.whg.model.Product1;
import com.whg.form.ProductForm;
import com.whg.validator.ProductValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



/**
 * Created by whg at 19-6-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class SaveProductController implements Controller  {
    private static final Log logger=LogFactory.getLog(SaveProductController.class);


    @Override
//    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
     public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
         logger.info("SavePoductController called");

        ProductForm productForm=new ProductForm();
        //populate form properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        //validate ProductForm
        ProductValidator productValidator=new ProductValidator();
        List<String> errors=productValidator.validate(productForm);
        if(errors.isEmpty()) {

            //create model
            Product1 product = new Product1();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {

            }
            //insert code to add product to the database
           // request.setAttribute("product", product);
           // return "/WEB-INF/jsp/ProductDetails.jsp";
            return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp","product",product);


        }
        else{
            //store errors and form in a scope variable for the view
            request.setAttribute("errors" ,errors);
            request.setAttribute("form",productForm);
//            return "/WEB-INF/jsp/ProductForm.jsp" ;
        return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");
        }


    }
}
