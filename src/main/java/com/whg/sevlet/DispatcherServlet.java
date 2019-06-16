package com.whg.sevlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.whg.controller.InputProductController;
import com.whg.controller.SaveProductController;
import javax.servlet.annotation.WebServlet;
/**
 * Created by whg at 19-6-11
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
//@WebServlet(name="DispatcherServlet",urlPatterns = {"/product_inputt.action" ,"/product_savee.action"})
public class DispatcherServlet extends HttpServlet {


    private static final long serialVersionUID = 989326116063292313L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response) ;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response) ;
    }
    private void process(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{


        String uri=request.getRequestURI();


        /*   uri is in this form:/contextName/resourceName ,for example:/app10a/product_input , However ,in the event of a default context, the context name is empty,and uri has this form resourceName ,e.g.:/product_inputd  ,*/
        int  lastIndex=uri.lastIndexOf("/") ;
        String action=uri.substring(lastIndex+1);

        String dispatchUrl=null;
        if(action.equals("product_inputt.action")){
//            dispatchUrl="/WEB-INF/jsp/ProductForm.jsp" ;
            InputProductController controller= new InputProductController();

//            dispatchUrl=controller.handleRequest(request,response);
        } else if(action.equals("product_savee.action")){
//            dispatchUrl="/WEB-INF/jsp/ProductDetails.jsp" ;ol
        SaveProductController controller=new SaveProductController();
//            dispatchUrl = controller.handleRequest(request,response);
        }
        if(dispatchUrl!=null){
            RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl) ;
            rd.forward(request,response);
        }

    }
}
