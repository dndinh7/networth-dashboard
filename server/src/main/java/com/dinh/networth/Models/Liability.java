package com.dinh.networth.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "liabilities")
public abstract class Liability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable= true)
    private double interest;

    @Column(name = "due_at", nullable= true)
    private LocalDateTime dueAt;

    @Column(nullable = true)
    private LocalDateTime date;

    @Column(nullable = true)
    private String source;

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version= version;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date= date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest= interest;
    }

    public LocalDateTime getDueAt() {
        return dueAt;
    }

    public void setDueAt(LocalDateTime dueAt) {
        this.dueAt= dueAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source= source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.version, this.date, this.name, this.value, this.user, this.interest, this.dueAt, this.source);
    }
}
