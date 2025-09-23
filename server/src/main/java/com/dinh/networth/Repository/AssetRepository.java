package com.dinh.networth.Repository;

import com.dinh.networth.Models.Asset;
import com.dinh.networth.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByName(String name);

    List<Asset> findByNameContaining(String name);

    List<Asset> findByUser(User user);
    List<Asset> findByUserId(Long userId);

    List<Asset> findByValueLessThanEqual(BigDecimal value);
    List<Asset> findByValueLessThan(BigDecimal value);
    List<Asset> findByValueGreaterThanEqual(BigDecimal value);
    List<Asset> findByValueGreaterThan(BigDecimal value);
    List<Asset> findByValue(BigDecimal value);

    List<Asset> findByInterest(BigDecimal interest);
    List<Asset> findByInterestGreaterThan(BigDecimal interest);
    List<Asset> findByInterestGreaterThanEqual(BigDecimal interest);
    List<Asset> findByInterestLessThan(BigDecimal interest);
    List<Asset> findByInterestLessThanEqual(BigDecimal interest);

    List<Asset> findByDate(LocalDateTime date);
    List<Asset> findByDateAfter(LocalDateTime date);
    List<Asset> findByDateBefore(LocalDateTime date);
    List<Asset> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
