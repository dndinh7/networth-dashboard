package com.dinh.networth.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at", nullable= false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "done_at", nullable= false)
    private LocalDateTime doneAt;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Transaction() {}

    public Transaction(String name, BigDecimal value, String category, User user, LocalDateTime doneAt) {
        this.name= name;
        this.value= value;
        this.user= user;
        this.doneAt= doneAt;
        this.createdAt= LocalDateTime.now();
        this.category= category;
    }

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

    public LocalDateTime getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDateTime doneAt) {
        this.doneAt= doneAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory() {
        this.category= category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.category, this.value, this.doneAt, this.createdAt, this.user);
    }
}
