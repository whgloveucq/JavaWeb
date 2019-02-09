package com.whg.listener;

/**
 * Created by whg at 19-2-9
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
//@WebListener
public class PerfStatListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
     ServletRequest servletRequest=sre.getServletRequest();
     servletRequest.setAttribute("start",System.nanoTime());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
       ServletRequest servletRequest=sre.getServletRequest();
       long start=(Long) servletRequest.getAttribute("start");
       long end=System.nanoTime();
       HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
       String uri=httpServletRequest.getRequestURI();
       System.out.println("time taken to execute" + uri + ":"+((end-start)/1000)+"microseconds");
    }
}
