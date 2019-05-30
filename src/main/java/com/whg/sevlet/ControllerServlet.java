package com.whg.sevlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.whg.model.Product2;
import com.whg.form.ProductForm;

public class ControllerServlet  extends HttpServlet{

    private static final long serialVersionUID = -169532686765685902L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }
    private void process(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
String uri=request.getRequestURI();
// uri is in this form: /contextName/resourceName,for example:/app10a/product_input.However,in the event of a default context,the context name is empty,and
//                uri has this form /resourceName,e,g:/product_input
int lastIndex=uri.lastIndexOf("/");
String action=uri.substring((lastIndex+1));
//excute an action
        if(action.equals("product_input.action")){
            // no action class,there is nothing to be done
        }
        else if(action.equals("product_save.action")){
            //create form
            ProductForm productForm = new ProductForm();
            //populate action properties
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
         //create model
            Product2 product =new Product2();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }catch(NumberFormatException e){}
            // code to save product
            //store model in a scope variable for the view
            request.setAttribute("product",product);
        }
        //forward to a view
        String dispatchUrl=null;
        if(action.equals("product_input.action")){
            dispatchUrl="/WEB-INF/jsp/ProductForm.jsp";
        } else if()

    }
}
