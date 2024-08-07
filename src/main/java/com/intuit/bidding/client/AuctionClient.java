package com.intuit.bidding.client;

import com.intuit.bidding.core.entity.ApiResponse;
import com.intuit.bidding.core.external.entity.Auction;
import com.intuit.bidding.core.external.request.AuctionSearchRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "auction-service-client", url = "http://localhost:9091/api")
public interface AuctionClient {

    @PostMapping("/v1/auctions/new")
    ResponseEntity<ApiResponse<Auction>> createAuction(@RequestBody Auction auction);

    @PostMapping("/v1/auctions/search")
    ResponseEntity<ApiResponse<List<Auction>>> searchAuctions(@RequestBody AuctionSearchRequest auctionSearchRequest);

    @GetMapping("/v1/auctions/id")
    ResponseEntity<ApiResponse<Auction>> getAuctionById(@RequestParam("auctionId") String auctionId);
}