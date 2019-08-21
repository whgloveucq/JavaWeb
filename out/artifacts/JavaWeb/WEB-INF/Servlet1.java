package com.whg.sevlet;

/**
 * Created by whg at 19-4-4
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/servlet1"} )
public class Servlet1 extends HttpServlet {


    private static final long serialVersionUID = -6146874429112323775L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/1.jsp");
         dispatcher.forward(request,response);
    }
}
