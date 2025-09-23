package com.dinh.networth.Repository;

import com.dinh.networth.Models.Liability;
import com.dinh.networth.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, Long> {

    List<Liability> findByName(String name);

    List<Liability> findByNameContaining(String name);

    List<Liability> findByUser(User user);
    List<Liability> findByUserId(Long userId);

    List<Liability> findByValueLessThanEqual(BigDecimal value);
    List<Liability> findByValueLessThan(BigDecimal value);
    List<Liability> findByValueGreaterThanEqual(BigDecimal value);
    List<Liability> findByValueGreaterThan(BigDecimal value);
    List<Liability> findByValue(BigDecimal value);

    List<Liability> findByInterest(BigDecimal interest);
    List<Liability> findByInterestGreaterThan(BigDecimal interest);
    List<Liability> findByInterestGreaterThanEqual(BigDecimal interest);
    List<Liability> findByInterestLessThan(BigDecimal interest);
    List<Liability> findByInterestLessThanEqual(BigDecimal interest);

    List<Liability> findByDate(LocalDateTime date);
    List<Liability> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<Liability> findByDateBefore(LocalDateTime date);
    List<Liability> findByDateAfter(LocalDateTime date);

    List<Liability> findByDueAt(LocalDateTime dueAt);
    List<Liability> findByDueAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Liability> findByDueAtBefore(LocalDateTime dueAt);
    List<Liability> findByDueAtAfter(LocalDateTime dueAt);

}
