package com.example.sidemenusakura.FoodMenuManagement;

public class FoodItemModelClass {

    Integer id;
    String price;
    String description;

    public FoodItemModelClass(String price, String description) {
        this.price = price;
        this.description = description;
    }

    public FoodItemModelClass(Integer id, String price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
