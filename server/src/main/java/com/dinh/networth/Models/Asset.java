package com.dinh.networth.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable= true)
    private BigDecimal interest;

    @Column(name = "acquired_at", nullable= true)
    private LocalDateTime acquiredAt;

    @Column(name = "created_at", nullable= false, updatable = false)
    private LocalDateTime createdAt;

    protected Asset() {}

    public Asset(String name, String category, BigDecimal value, User user, BigDecimal interest, LocalDateTime acquiredAt) {
        this.name= name;
        this.category= category;
        this.value= value;
        this.user= user;
        this.interest= interest;
        this.acquiredAt= acquiredAt;
        this.createdAt= LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Asset[id=%s, name=%s, category=%s, value=%f, userId=%s, interest=%f, acquiredAt=%s, createdAt=%s]", id, name, category, value, user.getId(), interest, acquiredAt, createdAt);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category= category;
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

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest= interest;
    }

    public LocalDateTime getAcquiredAt() {
        return acquiredAt;
    }

    public void setAcquiredAt(LocalDateTime acquiredAt) {
        this.acquiredAt= acquiredAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.category, this.value, this.user, this.interest, this.acquiredAt, this.createdAt);
    }
}
