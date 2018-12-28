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
writer.println("<html><head><title>Products</title>"+"</head><body><h2>Products</h2>");
writer.println("<ul>");
for (Product product:products){
    writer.println("<li>"+product.getName()+"("+currencyFormat.format(product.getPrice())+")("+"<a href='viewProductDetails?id="+product.getId()+"'>Details</a>");
}
writer.println("</ul>");
writer.println("<a href='viewCart'>View Cart </a>");
writer.println("</body></html>");

    }
    private Product getProduct(int productId){
      for(Product product:products){
          if(product.getId()==productId){

              return product;

          }

      }
      return  null;
    }

    private void sendProductDetails(HttpServletRequest request,HttpServletResponse response) throws IOException{
   response.setContentType("text/html");
   PrintWriter writer=response.getWriter();
   int productId=0;
try {
    productId=Integer.parseInt(request.getParameter("id"));/*get the current id if you click this item */
}catch (NumberFormatException e){

}
Product product=getProduct(productId);
if(product!=null){
    writer.println("<html><head>"+"<title>ProductDetails</title></head>"+"<body><h2>Product Details</h2>"
+"<form method='post' action='addToCart'>");
    writer.println("<input type='hidden' name='id'"+"value='"+productId+"'>");
    writer.println("<table>");
    writer.println("<tr><td> Name:</td><td>"+ product.getName()+"</td></tr>");
    writer.println("<tr><td> Description:</td><td>"+ product.getDescription()+"</td></tr>");
    writer.println("<tr>"+"<tr>" +"<td><input name='quantity' /></td>" + "<td><input type='submit' value='Buy'/>" +"</td>" +"</tr>");
    writer.println("<tr><td colspan='2'>" +"<a href='products'>Product List</a>" +"</td></tr>") ;
    writer.println("</table>") ;
    writer.println("</form></body>");
}
else {
    writer.println("No product found") ;
}

    }
private void showCart(HttpServletRequest request,HttpServletResponse response) throws IOException{

response.setContentType("text/html");
PrintWriter writer=response.getWriter();
writer.println("<html><head><title>Shopping Cart </title>" +"</head>");
writer.println("<body><a href='products'>"+"Products List</a>");
HttpSession session=request.getSession();
List<ShoppingItem>  cart= (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
if(cart !=null){
    writer.println("<table>");
    writer.print("<tr><td style='width:150px'>Quantity"+"</td>" +"<td style='width:150px'>Product</td>" + "<td>Amount</td></tr>");
    double total=0.0;
    for(ShoppingItem shoppingItem:cart){

   Product product=shoppingItem.getProduct();

    }


    }


}


}

}
