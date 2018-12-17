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
 * Created by whg at 18-12-17
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
@WebServlet(name="CookieInfoServlet" ,urlPatterns = {"/cookieInfo"})
public class CookieInfoServlet extends HttpServlet {

    private static final long serialVersionUID = -1660747338733704629L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
