package com.whg.sevlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlet", urlPatterns = "/javaweb/form")
public class FormServlet extends HttpServlet{
    private static final long serialVersionUID = 54L;
    private static final String Title="OrderForm";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer=resp.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>"+Title+"</title></head>");
        writer.print("<body><h1>"+Title+"</h1>");
        writer.print("<form method='post'>");
        writer.print("<table>");
        writer.print("<tr>");
        writer.print("<td>Name:</td>");
        writer.print("<td><input name='name'/></td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<td>Address:</td>");
        writer.print("<td><textarea name='address'"+"cols='40' rows='5'></textarea></td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<td>Country:</td>");
        writer.print("<td><select name='country'>");
        writer.println("<option>United States </option>");
        writer.println("<option>Canada </option>");
        writer.print("</select></td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<td>Delivery Method:</td>");

        writer.print("<td><input  type='radio'"+"name='deliveryMethod'"+"value='First Class' /> First Class");
        writer.print("<td><input  type='radio'"+"name='deliveryMethod'"+"value='Second Class' /> Second Class");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<td>Shipping Instructions:</td>");
        writer.print("<td><textarea name='instruction'"+"cols='40' rows='5'></textarea></td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.println("<td>&nbsp</td>");
        writer.print("<td><textarea name='instruction'"+"cols='40' rows='5'></textarea></td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<td>Please lend me the latest "+"Product Catalog:</td>");
        writer.print("<td><input type='checkbox'"+"name='catalogRequest'/></td>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<td>&nbsp</td>");
        writer.print("<td><input type='reset'/>"+"<input type='submit'/></td>");
        writer.print("<tr>");


        writer.print("</tr>");
        writer.print("</table>");
        writer.print("</form>");
        writer.print("</body>");
        writer.print("</html>");


    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer=resp.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>"+Title+"</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.println("<h1>"+Title+"</h1>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Name:</td>");
        writer.println("<td>"+req.getParameter("name" )
                +"</td>");

        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Address:</td>");
        writer.println("<td>"+req.getParameter("address" )
                +"</td>");

        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Country:</td>");
        writer.println("<td>"+req.getParameter("country" )
                +"</td>");

        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Shipping instructions:</td>");
        writer.println("<td>");
        String[] instructions=req.getParameterValues("instruction" );
        if (instructions!=null){

            for (String instruction:instructions)
            {
                writer.println(instruction+"<br/>");
            }
        }
        writer.println("</td>") ;

        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>CatalogRequest:</td>");
        writer.println("<td>");
        if(req.getParameter("CatalogRequest")==null)
        {
            writer.print("No");
        }
        else
        {
            writer.print("Yes");
        }
        writer.println("</td>");

        writer.println("</tr>");
        writer.print("</table>");

        writer.print("</body>");

        writer.print("</html>");




    }
}
