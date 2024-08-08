package com.intuit.bidding.client;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.ApiResponse;
import com.intuit.bidding.core.entity.Bidding;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bidding-service", url = "http://localhost:9092")
public interface BiddingClient {

    @PostMapping("/api/v1/bidding/save")
    ApiResponse<Bidding> addNewBid(@RequestBody Bidding bidding);

    @PostMapping("/api/v1/bidding/filter")
    ApiResponse<List<Bidding>> filterBid(@RequestBody BiddingSearchRequest biddingSearchRequest);

    @PostMapping("/api/v1/bidding/search")
    List<Bidding> searchAll();

    @GetMapping("/api/v1/bidding/accepted-bid")
    ApiResponse<Bidding> getAcceptedBidForAuction(@RequestParam("auctionId") String auctionId);

    @PutMapping("/api/v1/bidding/accept-final-bid")
    ApiResponse<Bidding> updateWinningBid(@RequestParam("auctionId") String auctionId);
}
