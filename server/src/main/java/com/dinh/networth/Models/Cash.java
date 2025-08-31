package com.dinh.networth.Models;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "cash")
public class Cash extends Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(nullable = true, precision = 5, scale = 2)
    private BigDecimal interest;

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset= asset;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest= interest;
    }
}
