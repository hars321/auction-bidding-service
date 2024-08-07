package com.intuit.bidding.core;

import com.intuit.bidding.core.enums.BidStatus;
import com.intuit.bidding.core.enums.BiddingSortEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class BiddingSearchRequest {
    public Set<BiddingSortEnum> getSort() {
        return sort;
    }

    public void setSort(Set<BiddingSortEnum> sort) {
        this.sort = sort;
    }

    private String auctionId;

    public BiddingSearchRequest() {
    }

    public BiddingSearchRequest(String auctionId, String userId, Long startTimeStamp, Long endTimeStamp, Set<BiddingSortEnum> sort, Integer count, BidStatus bidStatus) {
        this.auctionId = auctionId;
        this.userId = userId;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
        this.sort = sort;
        this.count = count;
        this.bidStatus = bidStatus;
    }

    private String userId;
    private Long startTimeStamp;
    private Long endTimeStamp;
    private Set<BiddingSortEnum> sort;
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


    public Integer getCount() {
        return count;
    }

    public BidStatus getBidStatus() {
        return bidStatus;
    }
}
