package com.springMVC.e_commerce_website.repository;

import com.springMVC.e_commerce_website.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
