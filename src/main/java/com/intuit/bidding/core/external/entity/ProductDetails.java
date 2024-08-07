package com.intuit.bidding.core.external.entity;

import lombok.Data;

@Data
public class ProductDetails {
    private String id;

    public ProductDetails() {
    }

    public ProductDetails(String id, String name, String category, String city) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String name;
    private String category;
    private String city;
}
