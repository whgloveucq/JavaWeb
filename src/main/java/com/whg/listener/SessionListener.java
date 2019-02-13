package com.whg.listener;

/**
 * Created by whg at 19-2-8
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext=servletContextEvent.getServletContext();
        servletContext.setAttribute("userCounter",new AtomicInteger());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
HttpSession session=httpSessionEvent.getSession();
ServletContext servletContext=session.getServletContext();
AtomicInteger userCounter=(AtomicInteger) servletContext.getAttribute("userCounter");
int userCount=userCounter.incrementAndGet();
System.out.println("userCount incremented to:" + userCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
HttpSession session=httpSessionEvent.getSession();
ServletContext servletContext=session.getServletContext();
AtomicInteger userCounter=(AtomicInteger) servletContext.getAttribute("userCounter");
int userCount=userCounter.decrementAndGet();
System.out.println("userCount decremente to :" + userCount);
    }

}
