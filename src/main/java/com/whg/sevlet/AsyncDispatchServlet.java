package com.whg.sevlet;

/**
 * Created by whg at 19-3-18
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name ="AsyncDispatchServlet" ,urlPatterns={"/asyncDispatch"},asyncSupported = true)
public class AsyncDispatchServlet  extends HttpServlet{

    private static final long serialVersionUID = -8182196989987661335L;

    @Override
    protected void doGet( final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final  AsyncContext asyncContext=request.startAsync();
        request.setAttribute("mainThread" ,Thread.currentThread().getName());
        asyncContext.setTimeout(5000); //ms
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                //long-running task
                try {
                    Thread.sleep(3000); //休眠3秒钟
                    System.out.println("休息三秒钟");
                }catch (InterruptedException e){

                }
                request.setAttribute("workerThread" ,Thread.currentThread().getName());
                asyncContext.dispatch("/threadNames.jsp");
            }
        });
    }

}
