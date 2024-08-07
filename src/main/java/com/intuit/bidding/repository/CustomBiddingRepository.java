package com.intuit.bidding.repository;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;

import java.util.List;

public interface CustomBiddingRepository {
    List<Bidding> filterBids(BiddingSearchRequest biddingSearchRequest);
}
