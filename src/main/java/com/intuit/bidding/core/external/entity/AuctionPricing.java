package com.intuit.bidding.core.external.entity;

import lombok.Data;

@Data
public class AuctionPricing {
    private Integer listedPrice;
    private Integer soldPrice;

    public AuctionPricing(Integer listedPrice, Integer soldPrice) {
        this.listedPrice = listedPrice;
        this.soldPrice = soldPrice;
    }

    public AuctionPricing() {
    }

    public Integer getListedPrice() {
        return listedPrice;
    }

    public void setListedPrice(Integer listedPrice) {
        this.listedPrice = listedPrice;
    }

    public Integer getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Integer soldPrice) {
        this.soldPrice = soldPrice;
    }
}
