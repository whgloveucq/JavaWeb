package com.whg.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="ShoppingCartServlet",urlPatterns = {"/products","/viewProductDetails","/addToCart","/viewCart"})
public class ShoppingCartServlet extends HttpServlet {


    private static final long serialVersionUID = 3869555414794748602L;
    private static final String CART_ATTRIBUTE="cart" ;
    private  List<Product> products=new ArrayList<Product>();
    private NumberFormat currencyFormat=NumberFormat.getCurrencyInstance(Locale.CHINA);

    @Override
    public void init() throws ServletException {
        products.add(new Product(1,"Bravo32'HDTV","Low-cost HDTV from renowned TV manufacturer",159.95F));
        products.add(new Product(2,"BravoBluRay Player","High quality stylish BluRay player",99.95F));
        products.add(new Product(3,"BravoStereo System","5 speaker hifi system with ipod player",129.95F));
        products.add(new Product(4,"Bravo iPod player","An iPod plug-in that can play multiple formats",39.95F));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String uri=request.getRequestURI();
        String contextpath= request.getContextPath().toString();
     if(uri.endsWith("/products")){


     }
    }

    private void sendProductList(HttpServletResponse response) throws  IOException{
  response.setContentType("text/html");
PrintWriter writer=response.getWriter();
writer.println("<html>");
    }

}
