package com.whg.sevlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//14.1
public class FirstServlet extends HttpServlet {

    private static final long serialVersionUID = -5880094973469609887L;
private String name;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter writer=response.getWriter();
    writer.println("<html><head><title>First servlet" + "</title></head><body>" +name) ;
    writer.println("</body>");
    }

    public void setName(String name) {
        this.name = name;
    }
}


