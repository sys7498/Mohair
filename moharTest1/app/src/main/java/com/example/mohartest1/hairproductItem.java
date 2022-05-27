package com.example.mohartest1;

import android.graphics.drawable.Drawable;

public class hairproductItem {

    String hairProductUrl;
    String brand;
    String productName;
    String price;



    public hairproductItem(String hairProductUrl, String brand, String productName, String price) {
        this.hairProductUrl = hairProductUrl;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
    }

    public String getHairProduct() {
        return hairProductUrl;
    }

    public void setHairProduct(String hairProduct) {
        this.hairProductUrl = hairProductUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


