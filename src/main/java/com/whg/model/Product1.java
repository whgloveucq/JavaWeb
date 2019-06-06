package com.whg.model;
import  java.io.Serializable;


/**
 * Created by whg at 19-6-6
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class Product1 implements Serializable{

    private static final long serialVersionUID = -984234164203546565L;
    private String name;
    private String description;
    private float price ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
