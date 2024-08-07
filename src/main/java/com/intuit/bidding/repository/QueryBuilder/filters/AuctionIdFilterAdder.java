package com.intuit.bidding.repository.QueryBuilder.filters;

import com.intuit.bidding.core.enums.FilterTypeEnum;
import com.intuit.bidding.core.request.BiddingSearchRequest;
import org.springframework.util.StringUtils;

public class AuctionIdFilterAdder extends AbstractFilterAdder {

    @Override
    String getFieldName() {
        return "auctionId";
    }

    @Override
    FilterTypeEnum getFilterTypeEnum() {
        return FilterTypeEnum.EQUAL;
    }

    @Override
    String getFieldValue(BiddingSearchRequest biddingSearchRequest) {
        return biddingSearchRequest.getAuctionId();
    }

    @Override
    boolean isValid(BiddingSearchRequest biddingSearchRequest) {
        return !StringUtils.isEmpty(biddingSearchRequest.getAuctionId());
    }
}
