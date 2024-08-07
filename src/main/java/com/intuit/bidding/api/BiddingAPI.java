package com.intuit.bidding.api;


import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.ApiResponse;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.service.BiddingService;
import com.intuit.bidding.util.ResponseUtil;
import com.intuit.bidding.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingAPI {

    @Autowired
    private BiddingService biddingService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Bidding>> addNewBid(@RequestBody Bidding bidding) {
        try {
            ValidationUtils.validateNewBid(bidding);
            Bidding result = biddingService.saveBid(bidding);
            return ResponseUtil.successResponse(result);
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Failed to place this bid", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<ApiResponse<List<Bidding>>> filterBid(@RequestBody BiddingSearchRequest biddingSearchRequest) {
        try {
            ValidationUtils.validateBiddingSearchRequest(biddingSearchRequest);
            return ResponseUtil.successResponse(biddingService.filterBid(biddingSearchRequest));
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Failed", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/search")
    public List<Bidding> searchAll() {
        return biddingService.searchAll();
    }

    @GetMapping("/accepted-bid")
    public ResponseEntity<ApiResponse<Bidding>> getAcceptedBidForAuction(@RequestParam("auctionId") String auctionId) {
        try {
            ValidationUtils.validateAuctionId(auctionId);
            Bidding bidding = biddingService.getAcceptedBidForAuction(auctionId);
            return ResponseUtil.successResponse(bidding, "Success");
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Error", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/accept-final-bid")
    public ResponseEntity<ApiResponse<Bidding>> updateWinningBid(@RequestParam("auctionId") String auctionId) {
        try {
            ValidationUtils.validateAuctionId(auctionId);
            return ResponseUtil.successResponse(biddingService.updateWinningBid(auctionId));
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Error fetching Bid details", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




