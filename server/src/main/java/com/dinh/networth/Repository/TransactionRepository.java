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

    List<Transaction> findByUser(User user);
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByValueLessThanEqual(BigDecimal value);
    List<Transaction> findByValueLessThan(BigDecimal value);
    List<Transaction> findByValueGreaterThanEqual(BigDecimal value);
    List<Transaction> findByValueGreaterThan(BigDecimal value);
    List<Transaction> findByValue(BigDecimal value);

    List<Transaction> findByDate(LocalDateTime date);
    List<Transaction> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<Transaction> findByDateBefore(LocalDateTime date);
    List<Transaction> findByDateAfter(LocalDateTime date);
}
