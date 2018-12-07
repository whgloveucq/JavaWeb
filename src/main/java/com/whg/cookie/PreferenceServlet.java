package com.whg.cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by whg at 18-12-7
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
@WebServlet(name="PreferenceServlet",urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet {

    private static final long serialVersionUID = 7455092399282340606L;
public static final  String MENU="<div style='background:#e8e8e8;"+"padding:15px'>" + "<a href='cookieClass'>Cookie Class </a>&nbsp;&nbsp;"
        +"<a href='cookieInfo'>Cookie Info </a> &nbsp;&nbsp;"+"<a href='preference'>Preference </a>"+"</div>";

    @Override
    protected void doGet(HttpServletRequest e HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
