package com.whg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//import org.springframework.stereotype.Controller; //annotation springmvc
import org.springframework.web.bind.annotation.RequestMapping ;

/**
 * Created by whg at 19-6-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/

public class InputProductController //implements Controller
{
    //    @Override
//    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        return "/WEB-INF/jsp/ProductForm.jsp";
//    }

    private static final Log logger = LogFactory.getLog(InputProductController.class);

    @RequestMapping(value="/product_input.action")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        logger.info("InputProductController called");
        System.out.println("let me look "+ request.getRequestURI().toString());
        return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");

    }


}
