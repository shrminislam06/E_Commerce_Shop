package com.springMVC.e_commerce_website.repository;

import com.springMVC.e_commerce_website.entity.InvoiceItem;
import com.springMVC.e_commerce_website.entity.InvoiceItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, InvoiceItemPk> {
}
