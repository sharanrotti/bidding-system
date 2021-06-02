package com.cars24.bidding.system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
public class Bid {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidId;

    @NotNull
    private BigDecimal bidAmount;

    @ManyToOne
    @JoinColumn(name="item_code")
    private Item item;

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
