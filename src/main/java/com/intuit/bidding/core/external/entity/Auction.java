package com.intuit.bidding.core.external.entity;

import com.intuit.bidding.core.external.enums.AuctionStatus;
import lombok.Data;

@Data
public class Auction {
    private String id;
    private UserDetails vendor;
    private ProductDetails productDetails;

    public Auction() {
    }

    public Auction(String id, UserDetails vendor, ProductDetails productDetails, AuctionStatus auctionStatus, Long listingTimestamp, Long auctionStartTimestamp, Long auctionEndTimeStamp, AuctionPricing auctionPricing) {
        this.id = id;
        this.vendor = vendor;
        this.productDetails = productDetails;
        this.auctionStatus = auctionStatus;
        this.listingTimestamp = listingTimestamp;
        this.auctionStartTimestamp = auctionStartTimestamp;
        this.auctionEndTimeStamp = auctionEndTimeStamp;
        this.auctionPricing = auctionPricing;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVendor(UserDetails vendor) {
        this.vendor = vendor;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public void setListingTimestamp(Long listingTimestamp) {
        this.listingTimestamp = listingTimestamp;
    }

    public void setAuctionStartTimestamp(Long auctionStartTimestamp) {
        this.auctionStartTimestamp = auctionStartTimestamp;
    }

    public void setAuctionEndTimeStamp(Long auctionEndTimeStamp) {
        this.auctionEndTimeStamp = auctionEndTimeStamp;
    }

    public void setAuctionPricing(AuctionPricing auctionPricing) {
        this.auctionPricing = auctionPricing;
    }

    private AuctionStatus auctionStatus;

    public String getId() {
        return id;
    }

    public UserDetails getVendor() {
        return vendor;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public Long getListingTimestamp() {
        return listingTimestamp;
    }

    public Long getAuctionStartTimestamp() {
        return auctionStartTimestamp;
    }

    public Long getAuctionEndTimeStamp() {
        return auctionEndTimeStamp;
    }

    public AuctionPricing getAuctionPricing() {
        return auctionPricing;
    }

    private Long listingTimestamp;
    private Long auctionStartTimestamp;
    private Long auctionEndTimeStamp;
    private AuctionPricing auctionPricing;
}
