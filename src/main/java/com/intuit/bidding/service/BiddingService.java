package com.intuit.bidding.service;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.request.BiddingSearchRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intuit.bidding.repository.BiddingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BiddingService {

    @Autowired
    private BiddingRepository biddingRepository;

    public Bidding saveBid(Bidding bidding){
        return biddingRepository.save(bidding);
    }

    public List<Bidding> filterBid(BiddingSearchRequest biddingSearchRequest){
        return biddingRepository.filterBids(biddingSearchRequest);
    }

    public List<Bidding> searchAll(){
        return biddingRepository.findAll();
    }
}
