package com.intuit.bidding.repository;

import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.request.BiddingSearchRequest;

import java.util.List;

public interface CustomBiddingRepository {
    List<Bidding> filterBids(BiddingSearchRequest biddingSearchRequest);
}
