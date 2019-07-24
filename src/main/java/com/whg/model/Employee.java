package com.whg.model;
import java.util.Date;

/**
 * Created by whg at 19-1-10
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
public class
Employee {

private int id;
private String name;
private Date birthDate;
private Address address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
