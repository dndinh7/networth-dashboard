package com.dinh.networth.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "assets")
public abstract class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(nullable= false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = true)
    private String source;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = true, precision = 5, scale = 2)
    private BigDecimal interest;

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version= version;
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

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source= source;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date= date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.version, this.date, this.name, this.user, this.value, this.source);
    }
}
