package com.dinh.networth.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable= false)
    private LocalDateTime date;

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "is_credit", nullable = false)
    private boolean isCredit;

    @Column(nullable = true)
    private String source;

    protected Transaction() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value= value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date= date;
    }

    public boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(boolean isCredit) {
        this.isCredit= isCredit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source= source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.value, this.user, this.isCredit, this.date, this.source);
    }
}
