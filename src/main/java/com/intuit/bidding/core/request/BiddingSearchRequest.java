package com.intuit.bidding.core.request;

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
}
