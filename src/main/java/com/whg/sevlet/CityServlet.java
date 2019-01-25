package com.whg.sevlet;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by whg at 19-1-25
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
@WebServlet(urlPatterns = {"/bigCities"})
public class CityServlet extends HttpServlet{


    private static final long serialVersionUID = -8982235947076473876L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Map<String,String>capitals=new HashMap<String, String>();
    capitals.put("China","Beijing");
    capitals.put("Indonesia","Jakarta");
    capitals.put("Malaysia","KualaLumpur");
    capitals.put("Thailand","Bangkok");
    request.setAttribute("capitals",capitals);
    Map<String,String[]> bigCities=new HashMap<String, String[]>();
    bigCities.put("China",new String[]{"Shanghai","Shenzhen","Guangzhou","Chongqing","Tianjin","Wuhan"});
    bigCities.put("Australia",new String[]{"Sydney","Melbourne","Perth"});
    bigCities.put("New Zealand",new String[]{"Auckland","Christchurch","Wellington"});
    bigCities.put("Indonesia",new String[]{"Jakarta","Surabaya","Medan"});
    request.setAttribute("capitals",capitals);
    request.setAttribute("bigCities",bigCities);
    RequestDispatcher rd=request.getRequestDispatcher("/Cities.jsp");
    rd.forward(request,response);

    }
}
