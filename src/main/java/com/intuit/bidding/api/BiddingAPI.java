package com.intuit.bidding.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.intuit.bidding.core.entity.ApiResponse;
import com.intuit.bidding.core.request.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.util.ResponseUtil;
import com.intuit.bidding.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.intuit.bidding.service.BiddingService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/bidding")
public class BiddingAPI {

    @Autowired
    private BiddingService biddingService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<Bidding>> addNewBid(@RequestBody Bidding bidding){
        if(!ValidationUtils.validateNewBid(bidding)){
            return ResponseUtil.errorResponse("Invalid Bid placed",HttpStatus.BAD_REQUEST);
        }
//        validate pricing with basePrice;
        Bidding result = biddingService.saveBid(bidding);
        if(Objects.nonNull(result)){
            return ResponseUtil.successResponse(result);
        }
        return ResponseUtil.errorResponse("Failed to place this bid", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/search/auctionId")
    public ResponseEntity<ApiResponse<List<Bidding>>> filterBid(@RequestBody BiddingSearchRequest biddingSearchRequest) {
        if(!ValidationUtils.validateBiddingSearchRequest(biddingSearchRequest)){
            return ResponseUtil.errorResponse("Invalid Bidding Search Request",HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.successResponse(biddingService.filterBid(biddingSearchRequest));
    }

    @PostMapping("/search")
    public List<Bidding> searchAll() {
        return biddingService.searchAll();
    }
}




