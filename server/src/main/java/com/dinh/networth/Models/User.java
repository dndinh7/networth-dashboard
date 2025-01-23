package com.dinh.networth.Models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified= false;

    @Column(name = "is_active", nullable = false)
    private boolean isActive= true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt= LocalDateTime.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asset> assets = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Liability> liabilities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    /*
    protected User() {}

    public User(String firstName, String lastName, String email, List<Asset> assets, List<Liability> liabilities, List<Transaction> transactions) {
        this.name= String.join(",", lastName, firstName);
        this.email= email;
        this.createdAt= LocalDateTime.now();
        this.assets= assets;
        this.liabilities= liabilities;
        this.transactions= transactions;
    }
    */

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s', email='%s', createdAt=%s]", id, name, email, createdAt);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets= assets;
    }

    public List<Liability> getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(List<Liability> liabilities) {
        this.liabilities= liabilities;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions= transactions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.email, this.assets, this.liabilities, this.transactions, this.createdAt);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // Should be encoded
    public void setPassword(String encodedPassword) {
        this.password= encodedPassword;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive= isActive;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified= isVerified;
    }

}
