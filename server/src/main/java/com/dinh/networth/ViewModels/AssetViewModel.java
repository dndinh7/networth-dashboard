package com.dinh.networth.ViewModels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AssetViewModel {
    private String id;
    private String name;
    private String category;
    private BigDecimal value;
    private String userId;
    private BigDecimal interest;
    private LocalDateTime acquiredAt;
    private LocalDateTime createdAt;

    public AssetViewModel(String id, String name, String category, BigDecimal value, String userId, BigDecimal interest, LocalDateTime acquiredAt, LocalDateTime createdAt) {
        this.id= id;
        this.name= name;
        this.category= category;
        this.value= value;
        this.userId= userId;
        this.interest= interest;
        this.acquiredAt= acquiredAt;
        this.createdAt= createdAt;
    }
}
