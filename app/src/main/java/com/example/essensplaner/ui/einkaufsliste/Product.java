package com.example.essensplaner.ui.einkaufsliste;

import java.util.ArrayList;

public class Product {
    private String name ;
    private String description;
    private String brand;
    private ArrayList<Product> similarProducts ;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description, String brand, ArrayList<Product> similarProducts) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.similarProducts = similarProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ArrayList<Product> getSimilarProducts() {
        return similarProducts;
    }

    public void setSimilarProducts(ArrayList<Product> similarProducts) {
        this.similarProducts = similarProducts;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
