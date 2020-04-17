package com.backend.transferOfObjects;

import com.backend.entity.enums.SubStatus;

public class StudentProductModel {
    private int idSubscription;
    private String name;
    private String description;
    private int price;
    private String img;
    private SubStatus subscriptionStatus;

    public StudentProductModel(){
    }

    public StudentProductModel(  int idSubscription, String name,
                                  String description, int price,
                                  String img, SubStatus subscriptionStatus){
        this.idSubscription = idSubscription;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.subscriptionStatus = subscriptionStatus;
    }


    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public SubStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}
