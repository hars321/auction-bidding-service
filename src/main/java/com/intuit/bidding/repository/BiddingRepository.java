package com.intuit.bidding.repository;


import com.intuit.bidding.core.entity.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, String>, CustomBiddingRepository {
    List<Bidding> searchBidsByAuctionId(String auctionId);
}