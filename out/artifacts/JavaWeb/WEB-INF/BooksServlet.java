package com.whg.sevlet;

import javax.servlet.http.HttpServlet;

/**
 * Created by whg at 19-1-15
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.jstl.core.*;
import com.whg.model.Book;
import com.whg.model.Category;
@WebServlet(urlPatterns = {"/books"})
public class BooksServlet extends HttpServlet {


    private static final long serialVersionUID = -8938201538831975212L;

    private List<Category> categories;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        categories=new ArrayList<Category>() ;
        Category category1=new Category(1,"Computing") ;
        Category category2=new Category(2,"Travel") ;
        Category category3=new Category(3,"Health") ;
        categories.add((category1));
        categories.add((category2));
        categories.add((category3));


        List<Book> books=new ArrayList<Book>();
        Book book1=new Book(1L,"9780980839623","Servlet&JSP:A Tutorial" ,58.8,category1,"BudiKurniawan");
        Book book2=new Book(2L,"9780985839623","C#：A Beginner's Tutorial" ,60.8,category2,"BautdDlsvnl") ;
        Book book3=new Book(3L,"9780984339623","Java 7 tutorial" ,75.8,category3,"Badkdsiksll");
    books.add(book1);
    books.add(book2);
    books.add(book3);
    request.setAttribute("books",books);
    RequestDispatcher rd=request.getRequestDispatcher("/BookList.jsp");
    rd.forward(request,response);

    }
}
