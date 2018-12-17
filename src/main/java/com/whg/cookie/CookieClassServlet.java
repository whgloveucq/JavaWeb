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
@WebServlet(name="CookieClassServlet",urlPatterns = {"/cookieClass"})
public class CookieClassServlet extends HttpServlet{


    private static final long serialVersionUID = -571207895142994776L;
    private String[] methods={
            "clone" ,
            "getComment",
            "getDomain",
            "getMaxAge",
            "getName",
            "getPath",
            "getSecure",
            "getValue",
            "getVersion",
            "isHttpOnly",
            "setComment",
            "setDomain",
            "setHttpOnly",
            "setMaxAge",
            "setPath",
            "setSecure",
            "setValue",
            "setVersion"

    } ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Cookie[] cookies=request.getCookies();
    Cookie maxRecordsCookie=null;
    if(cookies!=null)
    { for(Cookie cookie:cookies){
        if(cookie.getName().equals("maxRecords")){
            maxRecordsCookie=cookie;
            break;
        }


    }

    }
//    default
    int maxRecords=5;
if(maxRecordsCookie!=null) {
    try {
maxRecords=Integer.parseInt(maxRecordsCookie.getValue());
    } catch (NumberFormatException e){
//do nothing,use maxRecords default value
    }


}
response.setContentType("text/html");
PrintWriter writer=response.getWriter();
writer.print("<html><heda>"+"<title>CookieClass </title>" +"</head><body>"+ PreferenceServlet.MENU+"<div>Here are some of the methods in "
+"javax.servlet.http.Cookie");
writer.print("<ul>");
for(int i=0;i<maxRecords;i++){
writer.print("<li>"+methods[i]+"</li>");
}
writer.print("</ul>");
writer.print("</div></body></html>");


    }
}

