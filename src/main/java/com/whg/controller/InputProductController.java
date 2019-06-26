package com.whg.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * Created by whg at 19-6-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class InputProductController implements Controller{
    private static final Log logger=LogFactory.getLog(InputProductController.class);


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        logger.info("InputProductController called");
        System.out.println("let me see");
        return new ModelAndView("ProductForm");
        //return "/WEB-INF/jsp/ProductForm.jsp";
    }
}
