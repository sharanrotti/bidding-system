package com.cars24.bidding.system.controller;

import com.cars24.bidding.system.model.Bid;
import com.cars24.bidding.system.model.Item;
import com.cars24.bidding.system.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("auction")
public class AuctionController {

    //TODO
    // 1. Create proper relation for Auction -> Item -> Bid [Based on table structure] and use in appropriate place
    // 2. getAuctionStatus - Input we can change to Enum
    // 3. Place bid add appropriate return type and concurrency/race condition of bids for an auction.
    // 4. As soon as the auction is over, system should be able to notify the winner over the email.
    // 5. Good to Have Generally users will be placing the bid through a website or app and hence the system should be able to notify all users about the last highest placed bid.
    // 6. Change in memory -H2 db to MYSQL
    // 7. Test cases

    @Autowired
    AuctionService auctionService;

    @PostMapping("/start")
    public Item startAuction(@Valid @RequestBody Item item) {
        return auctionService.createAuction(item);
    }

    @GetMapping
    public Page<Item> getAuctionStatus(@RequestParam(name = "status") String status , @RequestParam Optional<Integer> page) {
        return auctionService.getAuctionStatus(status, page);
    }

    @PostMapping("/{itemCode}/bid")
    public Integer placeBid(@PathVariable("itemCode") Long itemCode, @RequestBody Bid bid) {
        return auctionService.placeBid(bid,itemCode).getBidId();
    }
}
