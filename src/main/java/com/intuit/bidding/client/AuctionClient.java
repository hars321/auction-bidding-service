package com.intuit.bidding.client;

import com.intuit.bidding.core.entity.Bidding;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "auction-service", url = "http://localhost:8081")
public interface AuctionClient {

    @GetMapping("/com/intuit/bidding/api/auctions")
    List<Bidding> getAuctions(@RequestParam("query") String query);
}
