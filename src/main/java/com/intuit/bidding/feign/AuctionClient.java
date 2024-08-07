//package feign;
//
//import entity.Auction;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@FeignClient(name = "auction-service", url = "http://localhost:8081")  // Replace with the actual service URL
//public interface AuctionClient {
//
//    @PostMapping("/api/auctions")
//    List<Auction> getAuctions(@RequestParam("query") String query);
//}