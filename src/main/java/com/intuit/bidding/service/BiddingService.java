package com.intuit.bidding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.enums.BidStatus;
import com.intuit.bidding.repository.BiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class BiddingService {

    @Autowired
    private BiddingRepository biddingRepository;

    public Bidding saveBid(Bidding bidding) {
        bidding.setBidStatus(BidStatus.BID_PLACED);
        bidding.setTimeStamp(Instant.now().toEpochMilli());
        return biddingRepository.save(bidding);
    }

    public List<Bidding> filterBid(BiddingSearchRequest biddingSearchRequest) {
        return biddingRepository.filterBids(biddingSearchRequest);
    }

    public List<Bidding> searchAll() {
        return biddingRepository.findAll();
    }
}
