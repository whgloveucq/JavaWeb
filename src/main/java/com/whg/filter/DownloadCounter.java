package com.whg.filter;

/**
 * Created by whg at 19-3-2
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
/*下载记数*/
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(filterName = "DownloadCounterFilter",urlPatterns = {"/*"})
public class DownloadCounter implements Filter {

    ExecutorService executorService=Executors.newSingleThreadExecutor();
    Properties downloadLog;
    File logFile;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("DownloadCounterFilter");
        String appPath=filterConfig.getServletContext().getRealPath("/");
        logFile=new File(appPath,"downloadlog.txt");
        if(!logFile.exists())
        {
           try{
               logFile.createNewFile();

           }catch (IOException e)
           {e.printStackTrace();}

        }
downloadLog= new Properties();
        try{

            downloadLog.load(new FileReader(logFile));
        } catch (IOException e)
        {
            e.printStackTrace();

        }
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest=(HttpServletRequest) request ;
    final String uri=httpServletRequest.getRequestURI();
    executorService.execute();
    }
}
