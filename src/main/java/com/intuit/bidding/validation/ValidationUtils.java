package com.intuit.bidding.validation;

import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.request.BiddingSearchRequest;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.util.Objects;

@UtilityClass
public class ValidationUtils {

    public static boolean validateNewBid(Bidding bidding) {
        if(Objects.isNull(bidding) || Objects.isNull(bidding.getBidPrice()) || StringUtils.isEmpty(bidding.getAuctionId()) || StringUtils.isEmpty(bidding.getUserId())){
            return false;
        }
        return true;
    }

    public static boolean validateBiddingSearchRequest(BiddingSearchRequest biddingSearchRequest) {
        if(Objects.isNull(biddingSearchRequest)){
            return false;
        }
        return true;
    }
}
