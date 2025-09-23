package com.dinh.networth.ViewModels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AssetViewModel {
    private String id;
    private int version;
    private LocalDateTime date;
    private String name;
    private String userId;
    private BigDecimal value;
    private String source;
    private BigDecimal interest;

    public AssetViewModel(String id, int version, LocalDateTime date, String name, String userId, BigDecimal value, String source, BigDecimal interest) {
        this.id= id;
        this.version= version;
        this.date= date;
        this.name= name;
        this.userId= userId;
        this.value= value;
        this.source= source;
        this.interest= interest;
    }
}
