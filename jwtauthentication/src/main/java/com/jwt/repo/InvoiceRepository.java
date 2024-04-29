package com.jwt.repo;

import com.jwt.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // invoice number, it will return the invoice of given invoice number
}
