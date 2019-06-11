package com.whg.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by whg at 19-6-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class InputProductController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/jsp/ProductForm.jsp";
    }
}
