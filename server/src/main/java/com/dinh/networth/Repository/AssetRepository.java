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

    List<Asset> findByCategory(String category);

    List<Asset> findByUser(User user);
    List<Asset> findByUserId(Long userId);

    List<Asset> findByValueLessThanEqual(BigDecimal value);
    List<Asset> findByValueLessThan(BigDecimal value);
    List<Asset> findByValueGreaterThanEqual(BigDecimal value);
    List<Asset> findByValueGreaterThan(BigDecimal value);
    List<Asset> findByValue(BigDecimal value);

    List<Asset> findByCategoryAndValue(String category, BigDecimal value);
    List<Asset> findByCategoryAndValueLessThanEqual(String category, BigDecimal value);
    List<Asset> findByCategoryAndValueLessThan(String category, BigDecimal value);
    List<Asset> findByCategoryAndValueGreaterThanEqual(String category, BigDecimal value);
    List<Asset> findByCategoryAndValueGreaterThan(String category, BigDecimal value);

    List<Asset> findByInterest(BigDecimal interest);
    List<Asset> findByInterestGreaterThan(BigDecimal interest);
    List<Asset> findByInterestGreaterThanEqual(BigDecimal interest);
    List<Asset> findByInterestLessThan(BigDecimal interest);
    List<Asset> findByInterestLessThanEqual(BigDecimal interest);

    List<Asset> findByCategoryAndInterest(String category, BigDecimal interest);
    List<Asset> findByCategoryAndInterestGreaterThan(String category, BigDecimal interest);
    List<Asset> findByCategoryAndInterestGreaterThanEqual(String category, BigDecimal interest);
    List<Asset> findByCategoryAndInterestLessThan(String category, BigDecimal interest);
    List<Asset> findByCategoryAndInterestLessThanEqual(String category, BigDecimal interest);

    List<Asset> findByAcquiredAt(LocalDateTime acquiredAt);
    List<Asset> findByAcquiredAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Asset> findByAcquiredAtBefore(LocalDateTime acquiredAt);
    List<Asset> findByAcquiredAtAfter(LocalDateTime acquiredAt);

    List<Asset> findByCreatedAt(LocalDateTime createdAt);
    List<Asset> findByCreatedAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Asset> findByCreatedAtBefore(LocalDateTime createdAt);
    List<Asset> findByCreatedAtAfter(LocalDateTime createdAt);

}
