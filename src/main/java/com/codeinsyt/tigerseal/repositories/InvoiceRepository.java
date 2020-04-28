package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Invoice e SET e.stat = ?2 WHERE e.id = ?1")
    @Transactional
    int softDelete(Long id, String status);
}
