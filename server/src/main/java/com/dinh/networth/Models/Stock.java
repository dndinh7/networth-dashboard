package com.dinh.networth.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "stocks")
public class Stock extends Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(nullable = false)
    private BigDecimal shares;

    @Column(nullable = false)
    private String ticker;

    @Column(name = "cost_basis", nullable = false)
    private BigDecimal costBasis;

    @Column(name = "cur_share_price", nullable = false)
    private BigDecimal curSharePrice;


    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset= asset;
    }

    public BigDecimal getShares() {
        return shares;
    }

    public void setShares(BigDecimal shares) {
        this.shares= shares;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker= ticker;
    }

    public BigDecimal getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(BigDecimal costBasis) {
        this.costBasis= costBasis;
    }

    public BigDecimal getCurSharePrice() {
        return curSharePrice;
    }

    public void setCurSharePrice(BigDecimal curSharePrice) {
        this.curSharePrice= curSharePrice;
    }

}
