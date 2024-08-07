package com.intuit.bidding.repository.QueryBuilder.filters;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.enums.FilterTypeEnum;
import org.springframework.util.StringUtils;

public class BidStatusFilterAdder extends AbstractFilterAdder {

    @Override
    String getFieldName() {
        return "bidStatus";
    }

    @Override
    FilterTypeEnum getFilterTypeEnum() {
        return FilterTypeEnum.EQUAL_BID_STATUS_ENUM;
    }

    @Override
    String getFieldValue(BiddingSearchRequest biddingSearchRequest) {
        return biddingSearchRequest.getBidStatus().name();
    }

    @Override
    boolean isValid(BiddingSearchRequest biddingSearchRequest) {
        return !StringUtils.isEmpty(biddingSearchRequest.getBidStatus());
    }
}
