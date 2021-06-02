package com.cars24.bidding.system.service;

import com.cars24.bidding.system.model.Bid;
import com.cars24.bidding.system.model.Item;
import com.cars24.bidding.system.repository.AuctionRepository;
import com.cars24.bidding.system.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    BidRepository bidRepository;

    public Item createAuction(Item item) {
        //TODO- Validation
        // 1. Item should be available in system
        // 2. There shouldn't be any running auction on the same item i.e. only one auction can b in running state for an item.
        return auctionRepository.save(item);
    }

    public List<Item> getAuctionStatus(String status) {
        return auctionRepository.findAll();
    }

    public Bid placeBid(Bid bid, Long itemCode) {
        Item item = auctionRepository.findByItemCode(itemCode);
        bid.setItem(item);
        return bidRepository.save(bid);
    }
}
