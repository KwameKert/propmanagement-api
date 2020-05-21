package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

        List<Transaction> findByUserId(Long id);

        @Query("SELECT SUM(t.amount) FROM Transaction t")
        double sumAmount();

}
