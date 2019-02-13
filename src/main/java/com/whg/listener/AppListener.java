package com.whg.listener;

/**
 * Created by whg at 19-2-8
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AppListener implements ServletContextListener  {

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        ServletContext servletContext=sce.getServletContext();
        Map<String,String> countries= new HashMap<String,String>();
        countries.put("ca" ,"Canada");
        countries.put("us","UnitedStates");
        servletContext.setAttribute("countries",countries); //实际开发中，往往是把数据库里的数据放置到ServletContext里。

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {



    }
}
