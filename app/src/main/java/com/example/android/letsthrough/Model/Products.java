package com.example.android.letsthrough.Model;

/**
 * Created by hp on 19-01-2019.
 */

public class Products {

    private String pname,description,price,image;

    public Products() {

    }

    public Products(String pname, String description, String price, String image) {
        this.pname = pname;
        this.description = description;
        this.price = price;
        this.image = image;

    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return "INR: "+price;
    }
    public String getPrice2() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
