package com.whg.service;
import java.util.ArrayList ;
import java.util.List;
import org.springframework.stereotype.Service;
import com.whg.model.Book;
import com.whg.model.Category;

@Service
public class BookServiceImpl implements BookService {

    /*this implementation is not thread-safe */
    private List<Category> categories;
    private List<Book> books;
    public BookServiceImpl(){
        categories=new ArrayList<Category>() ;
    Category category1=new Category(1,"Computing") ;
    Category category2=new Category(2,"Travel") ;
    Category category3=new Category(3,"Health") ;
     categories.add((category1));
     categories.add((category2));
     categories.add((category3));
     books =new ArrayList<Book>() ;
     //此处要采用数据库模式，以后处理。自己家的纸质书库。
     books.add(new Book(1L,"9780980839623","Servlet&JSP:A Tutorial" ,58.8,category1,"BudiKurniawan"));
     books.add(new Book(2L,"9780985839623","C#：A Beginner's Tutorial" ,60.8,category2,"BautdDlsvnl"));
     books.add(new Book(3L,"9780984339623","Java 7 tutorial" ,75.8,category3,"Badkdsiksll"));
    }
    public List<Category> getAllCategories(){

        return categories;

    }
    @Override
    public Category getCategory(int id){
        for(Category category:categories){
             if(id ==category.getId()){
                 return category;
             }

        }
        return  null;

    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book get(long id) {
        for ( Book book:books ){
            if(id == book.getId()){
                return  book ;
            }
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        int bookCount=books.size();
        for (int i =0 ;i<bookCount; i++){
            Book saveBook =books.get(i);
            if(saveBook.getId() == book.getId()){
                books.set(i,book);
                return book;
            }
        }
        return book;
    }

    @Override
    public long getNextId() {
        //needs to be locked
        long id=0L;
        for(Book book:books){
            long bookId= book.getId();
            if(bookId> id)
            {
                id=bookId;

            }

        }
    return  id + 1 ;
    }
}




