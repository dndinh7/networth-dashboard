package com.dinh.networth.Models;

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

    @Column(nullable = true)
    private double interest;

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset= asset;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest= interest;
    }
}
