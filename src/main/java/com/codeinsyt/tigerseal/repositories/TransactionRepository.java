package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

        List<Transaction> findByUserId(Long id);

}
