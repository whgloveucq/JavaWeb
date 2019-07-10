package com.whg.controller;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller ;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whg.model.Category;
import com.whg.service.BookService;
import com.whg.model.Book;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    private static final Log logger= LogFactory.getLog(BookController.class);
    @RequestMapping(value="/book_input")
    public String inputBook(Model model){

        List<Category> categories=bookService.getAllCategories();
        model.addAttribute("categories" ,categories) ;
        model.addAllAttributes("book",new Book()) ;
        return "BookAddForm" ;

    }
    @RequestMapping(value = "/book_edit/{id}")
    public String editBook()

}
