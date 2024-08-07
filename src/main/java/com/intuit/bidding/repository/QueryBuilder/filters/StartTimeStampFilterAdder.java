package com.intuit.bidding.repository.QueryBuilder.filters;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.enums.FilterTypeEnum;

import java.util.Objects;

public class StartTimeStampFilterAdder extends AbstractFilterAdder {

    @Override
    String getFieldName() {
        return "timeStamp";
    }

    @Override
    FilterTypeEnum getFilterTypeEnum() {
        return FilterTypeEnum.GREATER_THAN_OR_EQUAL;
    }

    @Override
    String getFieldValue(BiddingSearchRequest biddingSearchRequest) {
        return biddingSearchRequest.getStartTimeStamp().toString();
    }

    @Override
    boolean isValid(BiddingSearchRequest biddingSearchRequest) {
        return Objects.nonNull(biddingSearchRequest.getStartTimeStamp());
    }
}
