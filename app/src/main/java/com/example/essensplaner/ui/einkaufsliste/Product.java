package com.example.essensplaner.ui.einkaufsliste;

import java.util.ArrayList;

public class Product {
    private int amount;
    private String name;
    private String description;
    private String brand;
    private ArrayList<Product> similarProducts;

    public Product(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public Product(int amount, String name, String description, String brand, ArrayList<Product> similarProducts) {
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
