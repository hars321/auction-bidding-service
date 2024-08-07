package com.intuit.bidding.repository.QueryBuilder.filters;

import com.intuit.bidding.core.enums.FilterTypeEnum;
import com.intuit.bidding.core.request.BiddingSearchRequest;

import java.util.Objects;

public class EndTimeStampFilterAdder extends AbstractFilterAdder {

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
        return biddingSearchRequest.getEndTimeStamp().toString();
    }

    @Override
    boolean isValid(BiddingSearchRequest biddingSearchRequest) {
        return Objects.nonNull(biddingSearchRequest.getEndTimeStamp());
    }
}
