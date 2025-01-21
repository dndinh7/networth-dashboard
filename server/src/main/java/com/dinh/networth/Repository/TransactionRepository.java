package com.dinh.networth.Repository;

import com.dinh.networth.Models.Transaction;
import com.dinh.networth.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByName(String name);

    List<Transaction> findByNameContaining(String name);

    List<Transaction> findByCategory(String category);

    List<Transaction> findByUser(User user);
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByValueLessThanEqual(BigDecimal value);
    List<Transaction> findByValueLessThan(BigDecimal value);
    List<Transaction> findByValueGreaterThanEqual(BigDecimal value);
    List<Transaction> findByValueGreaterThan(BigDecimal value);
    List<Transaction> findByValue(BigDecimal value);

    List<Transaction> findByCategoryAndValue(String category, BigDecimal value);
    List<Transaction> findByCategoryAndValueLessThanEqual(String category, BigDecimal value);
    List<Transaction> findByCategoryAndValueLessThan(String category, BigDecimal value);
    List<Transaction> findByCategoryAndValueGreaterThanEqual(String category, BigDecimal value);
    List<Transaction> findByCategoryAndValueGreaterThan(String category, BigDecimal value);

    List<Transaction> findByDoneAt(LocalDateTime doneAt);
    List<Transaction> findByDoneAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Transaction> findByDoneAtBefore(LocalDateTime doneAt);
    List<Transaction> findByDoneAtAfter(LocalDateTime doneAt);

    List<Transaction> findByCreatedAt(LocalDateTime createdAt);
    List<Transaction> findByCreatedAtBetween(LocalDateTime startAt, LocalDateTime endAt);
    List<Transaction> findByCreatedAtBefore(LocalDateTime createdAt);
    List<Transaction> findByCreatedAtAfter(LocalDateTime createdAt);

}
