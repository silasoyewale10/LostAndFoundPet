package com.example.lostandfoundpet;


public class Pet {


    public long id;


    String name;
    String details;
    String img;
    String city;




    public Pet(String name, String details, String img, String city){

        this.name = name;
        this.details = details;
        this.img = img;
        this.city = city;

    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getImg() {
        return img;
    }

    public String getCity() {
        return city;
    }


}
