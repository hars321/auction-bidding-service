package com.intuit.bidding.validation;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.external.entity.Auction;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.util.Objects;

@UtilityClass
public class ValidationUtils {

    public static void validateNewBid(Bidding bidding) {
        if (Objects.isNull(bidding)
                || Objects.isNull(bidding.getBidPrice())
                || StringUtils.isEmpty(bidding.getAuctionId())
                || StringUtils.isEmpty(bidding.getUserId())) {
            throw new RuntimeException("Invalid bid placed");
        }
    }

    public static void validateBiddingSearchRequest(BiddingSearchRequest biddingSearchRequest) {
        if (Objects.isNull(biddingSearchRequest)) {
            throw new RuntimeException("Invalid Bidding Search Request");
        }
    }

    public static boolean isValidBidForAuction(Auction auction, Bidding bidding) {
        if (Objects.isNull(auction)
                || bidding.getBidPrice() < auction.getAuctionPricing().getListedPrice()
                || Objects.isNull(auction.getVendor())
                || bidding.getUserId().equals(auction.getVendor().getId())
                || auction.getAuctionStartTimestamp() > bidding.getTimeStamp()
                || auction.getAuctionEndTimeStamp() < bidding.getTimeStamp()) {
            return false;
        }
        return true;
    }

    public static void validateAuctionId(String auctionId) {
        if(StringUtils.isEmpty(auctionId)){
            throw new RuntimeException("Invalid auction id");
        }
    }
}
