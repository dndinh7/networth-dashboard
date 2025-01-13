package com.dinh.networth.Repository;

import com.dinh.networth.Models.Liability;
import com.dinh.networth.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface LiabilityRepository extends JpaRepository<Liability, Long> {

    List<Liability> findByName(String name);

    List<Liability> findByNameContaining(String name);

    List<Liability> findByCategory(String category);

    List<Liability> findByUser(User user);
    List<Liability> findByUserId(Long userId);

    List<Liability> findByValueLessThanEqual(BigDecimal value);
    List<Liability> findByValueLessThan(BigDecimal value);
    List<Liability> findByValueGreaterThanEqual(BigDecimal value);
    List<Liability> findByValueGreaterThan(BigDecimal value);
    List<Liability> findByValue(BigDecimal value);

    List<Liability> findByCategoryAndValue(String category, BigDecimal value);
    List<Liability> findByCategoryAndValueLessThanEqual(String category, BigDecimal value);
    List<Liability> findByCategoryAndValueLessThan(String category, BigDecimal value);
    List<Liability> findByCategoryAndValueGreaterThanEqual(String category, BigDecimal value);
    List<Liability> findByCategoryAndValueGreaterThan(String category, BigDecimal value);

    List<Liability> findByInterest(BigDecimal interest);
    List<Liability> findByInterestGreaterThan(BigDecimal interest);
    List<Liability> findByInterestGreaterThanEqual(BigDecimal interest);
    List<Liability> findByInterestLessThan(BigDecimal interest);
    List<Liability> findByInterestLessThanEqual(BigDecimal interest);

    List<Liability> findByCategoryAndInterest(String category, BigDecimal interest);
    List<Liability> findByCategoryAndInterestGreaterThan(String category, BigDecimal interest);
    List<Liability> findByCategoryAndInterestGreaterThanEqual(String category, BigDecimal interest);
    List<Liability> findByCategoryAndInterestLessThan(String category, BigDecimal interest);
    List<Liability> findByCategoryAndInterestLessThanEqual(String category, BigDecimal interest);

    List<Liability> findByAcquiredAt(LocalDateTime acquiredAt);
    List<Liability> findByAcquiredAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Liability> findByAcquiredAtBefore(LocalDateTime acquiredAt);
    List<Liability> findByAcquiredAtAfter(LocalDateTime acquiredAt);

    List<Liability> findByCreatedAt(LocalDateTime createdAt);
    List<Liability> findByCreatedAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Liability> findByCreatedAtBefore(LocalDateTime createdAt);
    List<Liability> findByCreatedAtAfter(LocalDateTime createdAt);

    List<Liability> findByDueAt(LocalDateTime dueAt);
    List<Liability> findByDueAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Liability> findByDueAtBefore(LocalDateTime dueAt);
    List<Liability> findByDueAtAfter(LocalDateTime dueAt);

}
