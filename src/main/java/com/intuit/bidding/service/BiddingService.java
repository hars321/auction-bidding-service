package com.intuit.bidding.service;

import com.intuit.bidding.client.AuctionClient;
import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.enums.BidStatus;
import com.intuit.bidding.core.enums.BiddingSortEnum;
import com.intuit.bidding.core.external.entity.Auction;
import com.intuit.bidding.core.external.enums.AuctionStatus;
import com.intuit.bidding.repository.BiddingRepository;
import com.intuit.bidding.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static com.intuit.bidding.util.TimeUtils.getCurrentTimeStamp;

@Service
public class BiddingService {

    @Autowired
    private BiddingRepository biddingRepository;
    @Autowired
    private AuctionClient auctionClient;

    public Bidding saveBid(Bidding bidding) {
        Auction auction = fetchAuctionDetails(bidding.getAuctionId());
        if (!ValidationUtils.isValidBidForAuction(auction, bidding)) {
            throw new RuntimeException("Invalid Bid request");
        }
        bidding.setBidStatus(BidStatus.BID_PLACED);
        bidding.setTimeStamp(getCurrentTimeStamp());
        return biddingRepository.save(bidding);
    }

    private Auction fetchAuctionDetails(String auctionId) {
        return auctionClient.getAuctionById(auctionId).getBody().getData();
    }

    public List<Bidding> filterBid(BiddingSearchRequest biddingSearchRequest) {
        return biddingRepository.filterBids(biddingSearchRequest);
    }

    public Bidding getAcceptedBidForAuction(String auctionId) {
        BiddingSearchRequest biddingSearchRequest = new BiddingSearchRequest();
        biddingSearchRequest.setAuctionId(auctionId);
        biddingSearchRequest.setBidStatus(BidStatus.BID_ACCEPTED);
        List<Bidding> biddingList = biddingRepository.filterBids(biddingSearchRequest);
        if (CollectionUtils.isEmpty(biddingList)) {
            throw new RuntimeException("No bid accepted for the current Auction");
        }
        return biddingList.get(0);
    }

    public List<Bidding> searchAll() {
        return biddingRepository.findAll();
    }

    public Bidding updateWinningBid(String auctionId) {
        Auction auction = auctionClient.getAuctionById(auctionId).getBody().getData();
        if (Objects.isNull(auction)) {
            throw new RuntimeException("Invalid Auction ID, auction does not exists");
        }
        if (auction.getAuctionEndTimeStamp() > getCurrentTimeStamp() || !auction.getAuctionStatus().equals(AuctionStatus.COMPLETED)) {
            throw new RuntimeException("Winning Bid can only be updated after auction ends");
        }
        Bidding acceptedBid = getAcceptedBidForAuction(auctionId);
        if (Objects.nonNull(acceptedBid)) {
            throw new RuntimeException("Winning bid already exists for the given auction");
        }
        Bidding highestActiveBid = getHighestActiveBid(auction);
        if (Objects.nonNull(highestActiveBid)) {
            highestActiveBid.setBidStatus(BidStatus.BID_ACCEPTED);
            acceptBid(highestActiveBid);
        }
        return highestActiveBid;
    }

    private void acceptBid(Bidding highestActiveBid) {
        biddingRepository.updateBidStatus(highestActiveBid.getId(), BidStatus.BID_ACCEPTED);
    }

    private Bidding getHighestActiveBid(Auction auction) {
        BiddingSearchRequest biddingSearchRequest = new BiddingSearchRequest();
        biddingSearchRequest.setCount(1);
        HashSet<BiddingSortEnum> biddingSortEnums = new HashSet<>();
        biddingSortEnums.add(BiddingSortEnum.PRICE_DESC);
        biddingSortEnums.add(BiddingSortEnum.TIMESTAMP_ASC);
        biddingSearchRequest.setSort(biddingSortEnums);
        biddingSearchRequest.setAuctionId(auction.getId());
        biddingSearchRequest.setStartTimeStamp(auction.getAuctionStartTimestamp());
        biddingSearchRequest.setEndTimeStamp(auction.getAuctionEndTimeStamp());
        return biddingRepository.filterBids(biddingSearchRequest).get(0);
    }
}
