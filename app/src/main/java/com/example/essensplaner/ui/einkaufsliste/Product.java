package com.example.essensplaner.ui.einkaufsliste;

public class Product {
    private int amount;
    private String name;
    private String description;
    private String brand;
    //TODO private ArrayList<Product> similarProducts;

    public Product(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public Product(int amount, String name, String description, String brand) {//TODO, ArrayList<Product> similarProducts
        this.amount = amount;
        this.name = name;
        this.description = description;
        this.brand = brand;
        //TODO this.similarProducts = similarProducts;
    }

    public Product() {
        this.amount = 0;
        this.name = "";
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

//TODO    public ArrayList<Product> getSimilarProducts() {
//        return similarProducts;
//    }
//    public void setSimilarProducts(ArrayList<Product> similarProducts) {
//        this.similarProducts = similarProducts;
//    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
