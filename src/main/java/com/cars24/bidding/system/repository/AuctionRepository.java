package com.cars24.bidding.system.repository;

import com.cars24.bidding.system.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Item, Integer> {

    Item findByItemCode(Long item_code);
}
