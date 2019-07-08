package com.whg.model;

/**
 * Created by whg at 19-2-9
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Product implements HttpSessionBindingListener {

    private Long id;
    private String name;
    private double price;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {

        String attributeName=event.getName();
        System.out.println(attributeName +"valueBound");

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

        String attributeName=event.getName();
        System.out.println(attributeName +"valueUnbound");
    }
}
