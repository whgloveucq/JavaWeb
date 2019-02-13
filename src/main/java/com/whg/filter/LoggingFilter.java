package com.whg.filter;

/**
 * Created by whg at 19-2-13
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
@WebFilter(filterName = "LoggingFilter",urlPatterns = {"/*"},initParams = {@WebInitParam(name="logFileName",value="log.txt"),@WebInitParam(name="prefix",value = "URI:")})
public class LoggingFilter implements Filter{
private PrintWriter logger;

private String prefix;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        prefix=filterConfig.getInitParameter("prefix");
        String logFileName=filterConfig.getInitParameter("logFileName");
        String appPath=filterConfig.getServletContext().getRealPath("/");
//        without path info in logFileName,the log file will be created in $TOMCAT_HOME/bin
 System.out.println("logFileName:" + logFileName);

 try{
logger=new PrintWriter(new File(appPath,logFileName));

 }catch (FileNotFoundException e) {
     e.printStackTrace();
     throw new ServletException(e.getMessage());
 }


    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
        if(logger!=null){
            logger.close();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
System.out.println("LoggingFilter.doFilter");
HttpServletRequest httpServletRequest=(HttpServletRequest)request;
logger.println(new Date() + "" + prefix + httpServletRequest.getRequestURI());
logger.flush();
filterChain.doFilter(request,response);
    }
}
