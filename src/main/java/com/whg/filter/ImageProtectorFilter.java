package com.whg.filter;

/**
 * Created by whg at 19-3-2
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import com.whg.filter.LoggingFilter;
import java.util.Date;
@WebFilter(filterName = "ImageProtectorFilter" ,urlPatterns = {"*.png","*.jpg","*.gif"})
public class ImageProtectorFilter implements Filter {
    private PrintWriter logger;

    private String prefix;
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig ) throws ServletException{}
    @Override
    public void destroy(){
    }
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain) throws IOException,ServletException{
        System.out.println("ImageProtectorFilter");
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        String referer=httpServletRequest.getHeader("referer");
        System.out.println("referer:" + referer) ;
        if(referer!=null){
            filterChain.doFilter(request,response);
        }else{
//
//          LoggingFilter loggingFilter=new LoggingFilter();
//           System.out.println("Have a look"+((HttpServletRequest) request).getServletPath() +"\n");
//           System.out.println("now  " +((FilterConfig) filterConfig).getServletContext().getRealPath("/"));
//           System.out.println("now2  " + ((HttpServletRequest) request).getServletContext().getRealPath("/"));
//            PrintWriter logger=(PrintWriter) new PrintWriter(new File(((HttpServletRequest) request).getContextPath(),"logg.txt")) ;
//logger.println(new Date() +"   ---image not available") ;
//        logger.flush();
        throw new ServletException("image not available") ;
        }




    }



}
