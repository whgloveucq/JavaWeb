package com.whg.model;
import java.io.Serializable;

public class Product2 implements Serializable {


    private static final long serialVersionUID = -4549851215938321884L;
    private String name ;
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
