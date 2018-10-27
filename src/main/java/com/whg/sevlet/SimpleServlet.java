package com.whg.sevlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet  {

    private static final long serialVersionUID = 7629707394569369387L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html");
    PrintWriter writer=resp.getWriter();
    writer.print("<html><head></head>"+"<body>SimpleServlet</body></html>" );
    }
}
