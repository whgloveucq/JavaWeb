package com.whg.model;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull ;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile ;

public class Product2 implements Serializable {


    private static final long serialVersionUID = -4549851215938321884L;
    @NotNull
    @Size(min=1,max=10)
    private String name ;
    private String description;
    private float price ;
    private List<MultipartFile> images;

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

    public void setPrice(float price) { this.price = price; }

    public List<MultipartFile> getImages() {
        return images;
    }
    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }




}
