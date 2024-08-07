package com.intuit.bidding.core.external.request;

import com.intuit.bidding.core.external.enums.AuctionStatus;
import lombok.Data;

@Data
public class AuctionSearchRequest {
    private String id;
    private String category;

    public AuctionSearchRequest() {
    }

    private AuctionStatus auctionStatus;
    private String city;

    public AuctionSearchRequest(String id, String category, AuctionStatus auctionStatus, String city, String startTimeStamp, String endTimeStamp, String productId) {
        this.id = id;
        this.category = category;
        this.auctionStatus = auctionStatus;
        this.city = city;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(String startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public String getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(String endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String startTimeStamp;
    private String endTimeStamp;
    private String productId;
}
