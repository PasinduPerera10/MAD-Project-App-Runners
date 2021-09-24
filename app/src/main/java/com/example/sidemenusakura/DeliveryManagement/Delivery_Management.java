package com.example.sidemenusakura.DeliveryManagement;


public class Delivery_Management {

    private int id;
    private String customername, address, contactnumber, totalprice;
    private long started, finished;


    public Delivery_Management(){

    }

    public Delivery_Management(int id, String customername, String address, String contactnumber, String totalprice, long started, long finished) {
        this.id = id;
        this.customername = customername;
        this.address = address;
        this.contactnumber = contactnumber;
        this.totalprice = totalprice;
        this.started = started;
        this.finished = finished;
    }

    public Delivery_Management(String customername, String address, String contactnumber, String totalprice, long started, long finished) {
        this.customername = customername;
        this.address = address;
        this.contactnumber = contactnumber;
        this.totalprice = totalprice;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}

