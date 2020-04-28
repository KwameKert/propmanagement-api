package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
