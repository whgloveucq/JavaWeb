package com.whg.model;
import java.io.Serializable;


/**
 * Created by whg at 19-1-15
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class Book  implements Serializable{

    private static final long serialVersionUID = 6807700410808089707L;
    private long id;
    private String isbn;
    private String title;
    private double price;
    private Category category;
    private String author;

    public Book() {
    }

    public Book(long id, String isbn, String title, double price, Category category, String author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.category = category;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
