package com.whg.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whg.model.Product;
import com.whg.model.Product1;
import com.whg.form.ProductForm;


/**
 * Created by whg at 19-6-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class SaveProductController implements Controller  {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        ProductForm productForm=new ProductForm();
        //populate form properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        //create model
        Product1 product= new Product1();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }catch (NumberFormatException e){

        }
        //insert code to add product to the database
        request.setAttribute("product",product);
        return "/WEB-NF/jsp/ProductDetails.jsp" ;


    }
}
