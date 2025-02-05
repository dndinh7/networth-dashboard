package com.dinh.networth.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property extends Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset= asset;
    }
}
