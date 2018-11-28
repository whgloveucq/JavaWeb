package com.whg.session;
/**
 * Created by whg at 18-11-27
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UrlWriting", urlPatterns = {"/urlwriting"})
public class UrlRewriting extends HttpServlet {

    private static final long serialVersionUID = 2073616010905463789L;
    private List<String> londonAttractions;
    private List<String> parisAttractions;



    @Override
    public void init() throws ServletException {
        londonAttractions = new ArrayList<String>(10);
        londonAttractions.add("BuckinghamPalace");
        londonAttractions.add("British Museum");
        londonAttractions.add("NationGallery");
        londonAttractions.add("LondonEyes");
        londonAttractions.add("BigBen");
        londonAttractions.add("Tower of London");
        londonAttractions.add("Natural History Museum");
        londonAttractions.add("CanaryWharf");
        londonAttractions.add("2012 Olympic Park");
        londonAttractions.add("St Paul's Cathedral");
        parisAttractions =new ArrayList<String>(10);
        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Notre Dame");
        parisAttractions.add("The Louvre");
        parisAttractions.add("ChampsElysees");
        parisAttractions.add("Arc deTriomphe");
        parisAttractions.add("Sainte Chapelle Church");
        parisAttractions.add("Les Invalides");
        parisAttractions.add("Museed'Orsay");
        parisAttractions.add("Montmarte");
        parisAttractions.add("Sacre Couer Basilica");
    }
@Override
    public  void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
    String city=request.getParameter("city");
    if (city!=null && (city.equals("london")||city.equals("paris"))){
//        show attractions
        showAttractions(request,response,city);
    }
    else{
//        show main page
showMainPage(request,response);
    }

}
private void showMainPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,
        IOException{
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        writer.print("<html><head>"+"<title>TOP 10 Tourist Attractions</title>"
        +"</head><body>"+"Please select a city:"+
                "</br><a href='?city=london'>London</a>"+
                "</br><a href='?city=paris'>Paris</a>" + "</body></html>"
        );

}
private  void showAttractions(HttpServletRequest request,HttpServletResponse response,String city)throws ServletException,
IOException{
int page=1;
String pageParameter=request.getParameter("page");
if(pageParameter!=null){
    try{
        page=Integer.parseInt(pageParameter);

    }catch (NumberFormatException e){
//        do nothing and retain default value for page
    }
    if(page>2)
    {
        page=1;
    }
}
List<String> attractions=null;
if(city.equals("london")){
    attractions=londonAttractions;
}
response.setContentType("text/html");
PrintWriter writer=response.getWriter();
writer.println("<html><head>"+"<title>Top 10  Tourist Attractions</title>"
+"</head><body>");
writer.println("<a href='UrlRewriting'>Select City</a>");
writer.println("<hr/>Page"+page+"<hr/>");
int start=page*5 -5;
for (int i=start;i<start+5;i++){
    writer.println(attractions.get(i)+"<br/>");
}
writer.print("<hr style='color:blue'/>"+"<a href='?city="+city+"&page=1'>Page1</a>");
writer.print("&nbsp ;<a href='?city="+city+"&page=2'>Page2</a>");
writer.println("</body></html>");
}

}

