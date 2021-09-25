package com.example.sidemenusakura.OrderManagement;

public class OrderModelClass {

    Integer id;
    String name;
    String quantity;
    String delivery;


    public OrderModelClass(String name, String quantity, String delivery) {
        this.name = name;
        this.quantity = quantity;
        this.delivery= delivery;
    }

    public OrderModelClass(Integer id, String name, String quantity, String delivery) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.delivery = delivery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String name) {
        this.name = name;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
