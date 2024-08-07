package com.intuit.bidding.core;

import com.intuit.bidding.core.enums.BidStatus;
import com.intuit.bidding.core.enums.BiddingSortEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BiddingSearchRequest {
    private String auctionId;
    private String userId;
    private Long startTimeStamp;
    private Long endTimeStamp;
    private BiddingSortEnum sort;
    private Integer count;
    private BidStatus bidStatus;

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStartTimeStamp(Long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public void setEndTimeStamp(Long endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public void setSort(BiddingSortEnum sort) {
        this.sort = sort;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getUserId() {
        return userId;
    }

    public Long getStartTimeStamp() {
        return startTimeStamp;
    }

    public Long getEndTimeStamp() {
        return endTimeStamp;
    }

    public BiddingSortEnum getSort() {
        return sort;
    }

    public Integer getCount() {
        return count;
    }

    public BidStatus getBidStatus() {
        return bidStatus;
    }
}
