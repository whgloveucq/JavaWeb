package com.whg.sevlet;

/**
 * Created by whg at 19-3-19
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
import com.whg.listener.MyAsyncListener;
@WebServlet(name="AsyncListenServlet" ,urlPatterns = {"/asyncListener"},asyncSupported = true)
public class AsyncListenerServlet extends HttpServlet {

    private static final long serialVersionUID = -9157900216284402032L;

    @Override
    public void doGet(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final AsyncContext asyncContext=request.startAsync();
        asyncContext.setTimeout(5000);
        asyncContext.addListener(new MyAsyncListener());
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                    System.out.println(Thread.activeCount());

                }catch (InterruptedException e){ System.out.println(" interruption exception " + e.getMessage()) ;}
                String greeting="hi from listener" ;
                System.out.println("wait ...") ;
                request.setAttribute("greeting" ,greeting);
                asyncContext.dispatch("/index.jsp");
            }
        });

    }
}
