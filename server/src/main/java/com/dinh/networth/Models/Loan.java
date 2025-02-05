package com.dinh.networth.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "loan")
public class Loan extends Liability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "liability_id", nullable = false)
    private Liability liability;

    public Long getId() {
        return id;
    }

    public Liability getLiability() {
        return liability;
    }

    public void setLiability(Liability liability) {
        this.liability= liability;
    }
}
