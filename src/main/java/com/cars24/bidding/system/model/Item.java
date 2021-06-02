package com.cars24.bidding.system.model;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="item_details")
public class Item {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer itemId;
    @NotNull(message = "Please provide item Code")
    @Column(name="item_code")
    private Long itemCode;
    @NotNull(message = "Please provide base Price")
    @Column(name="base_price")
    private BigDecimal basePrice;
    @NotNull(message = "Please provide step Rate")
    @Column(name="step_rate")
    private BigDecimal stepRate;
    @CreationTimestamp
    @Column(name="start_time")
    private Timestamp starTime;
    @Column(name="end_time")
    private Timestamp endTime;
    @NotNull(message = "Please provide duration")
    private Float duration;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getStepRate() {
        return stepRate;
    }

    public void setStepRate(BigDecimal stepRate) {
        this.stepRate = stepRate;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }
}
